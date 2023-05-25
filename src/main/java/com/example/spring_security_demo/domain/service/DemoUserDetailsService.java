package com.example.spring_security_demo.domain.service;

import com.example.spring_security_demo.domain.dto.CreateUserRequest;
import com.example.spring_security_demo.domain.dto.UpdateUserRequest;
import com.example.spring_security_demo.persistance.crud.UserCrudRepository;
import com.example.spring_security_demo.persistance.mapper.UserSaveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ValidationException;

@Service
public class DemoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserCrudRepository userRepo;

    @Autowired
    private UserSaveMapper saveMapper;
    @Transactional
    public UserView create(CreateUserRequest request) {
        if (userRepo.findByUsername(request.username()).isPresent()) {
            throw new ValidationException("Username exists!");
        }
        if (!request.password().equals(request.rePassword())) {
            throw new ValidationException("Passwords don't match!");
        }

        var user = saveMapper.create(request);
        user.setPassword(passwordEncoder.encode(request.password()));

        user = userRepo.save(user);

        return userViewMapper.toUserView(user);
    }

    @Transactional
    public UserView update(Integer id, UpdateUserRequest request) {
        var user = userRepo.getById(id);
        saveMapper.update(request, user);

        user = userRepo.save(user);

        return userViewMapper.toUserView(user);
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
