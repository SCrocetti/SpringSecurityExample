package com.example.spring_security_demo.persistance.mapper;

import com.example.spring_security_demo.persistance.crud.RoleCrudRepository;
import com.example.spring_security_demo.persistance.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class RoleMapper {
    @Autowired
    private RoleCrudRepository roleCrudRepository;

    @Mappings({
            @Mapping(source = "roleName", target = "roleId", qualifiedByName = "nameToId"),
            @Mapping(source = "roleName", target = "roleName"),
            @Mapping(target = "users",ignore = true)
    })
    public abstract Role toRole(String roleName);
    @Named("nameToId")
    protected Integer nameToId(String roleName) {
        return roleCrudRepository.findByRoleName(roleName)
                .map(Role::getRoleId)
                .orElse(1);
    }
}