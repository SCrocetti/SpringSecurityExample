package com.example.spring_security_demo.domain.service;

import com.example.spring_security_demo.domain.dto.*;
import com.example.spring_security_demo.persistance.crud.UserCrudRepository;
import com.example.spring_security_demo.persistance.entity.User;
import com.example.spring_security_demo.persistance.exception.NotFoundException;
import com.example.spring_security_demo.persistance.mapper.UserDtoMapper;
import com.example.spring_security_demo.persistance.mapper.UserSaveMapper;
import org.mapstruct.control.MappingControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ValidationException;
import java.util.List;
import java.util.Optional;

@Service
public class DemoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserCrudRepository userRepo;

    @Autowired
    private UserSaveMapper saveMapper;

    @Autowired
    private UserDtoMapper dtoMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Transactional
    public UserDto create(CreateUserRequest request) {
        if (userRepo.findByUsername(request.username()).isPresent()) {
            throw new ValidationException("Username exists!");
        }
        if (!request.password().equals(request.rePassword())) {
            throw new ValidationException("Passwords don't match!");
        }

        var user = saveMapper.create(request);
        user.setPassword(passwordEncoder.encode(request.password()));

        user = userRepo.save(user);

        return dtoMapper.toUserDto(user);
    }

    @Transactional
    public UserDto updateInfo(Integer id, UpdateUserInfoRequest request) {
        var user = userRepo.getById(id);
        saveMapper.updateInfo(request, user);

        user = userRepo.save(user);

        return dtoMapper.toUserDto(user);
    }
    @Transactional
    public UserDto updateAuthorities(Integer id, UpdateUserAuthoritiesRequest request) {
        var user = userRepo.getById(id);
        saveMapper.updateAuthorities(request, user);

        user = userRepo.save(user);

        return dtoMapper.toUserDto(user);
    }
    @Transactional
    public UserDto updatePassword(Integer id, UpdateUserPasswordRequest request) {
        var user = userRepo.getById(id);
        if(!user.getPassword().equals(passwordEncoder.encode(request.oldPassword()))){
            throw new ValidationException("Original password don't match");
        }
        if (!request.newPassword().equals(request.reNewPassword())) {
            throw new ValidationException("Passwords don't match!");
        }

        user.setPassword(passwordEncoder.encode(request.newPassword()));
        user = userRepo.save(user);

        return dtoMapper.toUserDto(user);
    }
    public UserDto findById(Integer id){
        return  userRepo.findById(id).map(user->{
            return dtoMapper.toUserDto(user);
        }).orElseThrow(
                ()-> new NotFoundException(User.class,id)
        );
    }
    public List<UserDto> findAll(){
        return dtoMapper.toUserDto(userRepo.findAll());
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo
                .findByUsername(username)
                .orElseThrow(
                        () ->
                                new UsernameNotFoundException(
                                        String.format("User with username - %s, not found", username)));
    }
}
