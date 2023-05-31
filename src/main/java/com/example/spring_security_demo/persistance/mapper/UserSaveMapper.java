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
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toSet;
import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;
@Component
@Mapper(componentModel = "spring",uses = {UserRoleMapper.class})
public abstract  class UserSaveMapper {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Mappings({
            @Mapping(source="userId",target = "userId" ),
            @Mapping(source="username",target = "username" ),
            @Mapping(source = "password", target = "password" ),
            @Mapping(source="firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName" ),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "authorities", target = "authorities", qualifiedByName = "stringToUserRole"),
            @Mapping(source = "creationDateTime", target = "creationDateTime" ),
            @Mapping(source = "creationUserId", target = "creationUserId"),
            @Mapping(source = "modificationDateTime", target = "modificationDateTime" ),
            @Mapping(source = "modificationUserId", target = "modificationUserId" ),
            @Mapping(source = "enabled", target = "enabled" ),
            @Mapping(source = "creationUser", target = "creationUser"),
            @Mapping(source = "createdUsers", target = "createdUsers" ),
            @Mapping(source = "modificationUser", target = "modificationUser"),
            @Mapping(source = "modifiedUsers", target = "modifiedUsers")
    })
    public abstract void updateAuthorities(UpdateUserAuthoritiesRequest request, @MappingTarget User user);
    @Mappings({
            @Mapping(source="userId",target = "userId" ),
            @Mapping(source="username",target = "username" ),
            @Mapping(source = "password", target = "password" ),
            @Mapping(source="firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName" ),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "authorities", target = "authorities"),
            @Mapping(source = "creationDateTime", target = "creationDateTime" ),
            @Mapping(source = "creationUserId", target = "creationUserId"),
            @Mapping(source = "modificationDateTime", target = "modificationDateTime" ),
            @Mapping(source = "modificationUserId", target = "modificationUserId" ),
            @Mapping(source = "enabled", target = "enabled" ),
            @Mapping(source = "creationUser", target = "creationUser"),
            @Mapping(source = "createdUsers", target = "createdUsers" ),
            @Mapping(source = "modificationUser", target = "modificationUser"),
            @Mapping(source = "modifiedUsers", target = "modifiedUsers")
    })
    public abstract void updateInfo(UpdateUserInfoRequest request, @MappingTarget User user);

    @Mappings({
            @Mapping(source="userId",target = "userId" ),
            @Mapping(source="username",target = "username" ),
            @Mapping(source = "password", target = "password" ),
            @Mapping(source="firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName" ),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "authorities", target = "authorities", qualifiedByName = "stringToUserRole"),
            @Mapping(source = "creationDateTime", target = "creationDateTime" ),
            @Mapping(source = "creationUserId", target = "creationUserId"),
            @Mapping(source = "modificationDateTime", target = "modificationDateTime" ),
            @Mapping(source = "modificationUserId", target = "modificationUserId" ),
            @Mapping(source = "enabled", target = "enabled" ),
            @Mapping(source = "creationUser", target = "creationUser"),
            @Mapping(source = "createdUsers", target = "createdUsers" ),
            @Mapping(source = "modificationUser", target = "modificationUser"),
            @Mapping(source = "modifiedUsers", target = "modifiedUsers")
    })
    public abstract User create(CreateUserRequest request);
    @Named("stringToRole")
    protected Set<UserRole> stringToUserRole(Integer userId, Set<String> authorities) {
        if (authorities != null) {
            return userRoleMapper.toUserRole(userId,authorities);
        }
        return new HashSet<>();
    }
}
