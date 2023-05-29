package com.example.spring_security_demo.persistance.mapper;
import com.example.spring_security_demo.domain.dto.CreateUserRequest;
import com.example.spring_security_demo.domain.dto.UpdateUserAuthoritiesRequest;
import com.example.spring_security_demo.domain.dto.UpdateUserInfoRequest;
import com.example.spring_security_demo.domain.dto.UpdateUserPasswordRequest;
import com.example.spring_security_demo.persistance.crud.RoleCrudRepository;
import com.example.spring_security_demo.persistance.entity.Role;
import com.example.spring_security_demo.persistance.entity.User;
import com.example.spring_security_demo.persistance.entity.UserRole;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toSet;
import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(componentModel = "spring", uses=Integer.class)
public abstract  class UserSaveMapper {

    @Autowired
    private RoleCrudRepository roleCrudRepository;


    @Mapping(source = "authorities", target = "authorities", qualifiedByName = "stringToRole")
    public abstract User create(CreateUserRequest request);

    @BeanMapping(nullValueCheckStrategy = ALWAYS, nullValuePropertyMappingStrategy = IGNORE)
    @Mapping(source = "authorities", target = "authorities", qualifiedByName = "stringToUserRole")
    public abstract void updateAuthorities(UpdateUserAuthoritiesRequest request, @MappingTarget User user);
    @BeanMapping(nullValueCheckStrategy = ALWAYS, nullValuePropertyMappingStrategy = IGNORE)
    public abstract void updateInfo(UpdateUserInfoRequest request, @MappingTarget User user);

    @Named("stringToRole")
    protected Set<UserRole> stringToUserRole(Set<String> authorities) {
        if (authorities != null) {
            return authorities.stream().map(auth->{
                UserRole userRole=new UserRole();
                userRole.setRole(roleCrudRepository.findByRolename(auth).orElse(new Role()));
                return userRole;
            }).collect(toSet());
        }
        return new HashSet<>();
    }
}
