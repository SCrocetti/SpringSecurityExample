package com.example.spring_security_demo.persistance.mapper;

import com.example.spring_security_demo.persistance.crud.RoleCrudRepository;
import com.example.spring_security_demo.persistance.entity.Role;
import com.example.spring_security_demo.persistance.entity.RoleName;
import com.example.spring_security_demo.persistance.entity.UserRole;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;
@Component
@Mapper(componentModel = "spring")
public class RoleMapper {
    @Autowired
    private RoleCrudRepository roleCrudRepository;
    public Role toRole(String roleName){
        return roleCrudRepository.findByRolename(roleName)
                .orElse(
                        new Role(1, RoleName.NONE)
                );
    }
    public Set<Role> toRole(Set<String> authorities){
        return  authorities
                .stream()
                .map(auth-> toRole(auth))
                .collect(Collectors.toSet());
    }
}
