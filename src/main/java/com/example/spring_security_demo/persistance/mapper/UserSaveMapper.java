package com.example.spring_security_demo.persistance.mapper;
import com.example.spring_security_demo.domain.dto.CreateUserRequest;
import com.example.spring_security_demo.domain.dto.UpdateUserAuthoritiesRequest;
import com.example.spring_security_demo.domain.dto.UpdateUserInfoRequest;
import com.example.spring_security_demo.persistance.entity.User;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring",uses = {UserRoleMapper.class})
public abstract  class UserSaveMapper {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Mappings({
            @Mapping(target = "userId" ,ignore = true),
            @Mapping(target = "username" ,ignore = true),
            @Mapping(target = "password" ,ignore = true),
            @Mapping(target = "firstName",ignore = true),
            @Mapping( target = "lastName",ignore = true ),
            @Mapping(target = "email",ignore = true),
            @Mapping(source = "authorities", target = "authorities"),
            @Mapping(target = "creationDateTime" ,ignore = true),
            @Mapping(target = "creationUserId",ignore = true),
            @Mapping(target = "modificationDateTime",ignore = true ),
            @Mapping(target = "modificationUserId",ignore = true ),
            @Mapping( target = "enabled" ,ignore = true),
            @Mapping( target = "creationUser",ignore = true),
            @Mapping(target = "createdUsers" ,ignore = true),
            @Mapping(target = "modificationUser",ignore = true),
            @Mapping(target = "modifiedUsers",ignore = true)
    })
    public abstract void updateAuthorities(UpdateUserAuthoritiesRequest request, @MappingTarget User user);
    @Mappings({
            @Mapping(source="userId",target = "userId" ),
            @Mapping(source="username",target = "username" ),
            @Mapping(source = "password", target = "password" ),
            @Mapping(source="firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName" ),
            @Mapping(source = "email", target = "email"),
            @Mapping( target = "authorities",ignore = true),
            @Mapping(target = "creationDateTime" ,ignore = true),
            @Mapping(target = "creationUserId",ignore = true),
            @Mapping(target = "modificationDateTime",ignore = true ),
            @Mapping(target = "modificationUserId",ignore = true ),
            @Mapping( target = "enabled" ,ignore = true),
            @Mapping( target = "creationUser",ignore = true),
            @Mapping(target = "createdUsers" ,ignore = true),
            @Mapping(target = "modificationUser",ignore = true),
            @Mapping(target = "modifiedUsers",ignore = true)
    })
    public abstract void updateInfo(UpdateUserInfoRequest request, @MappingTarget User user);

    @Mappings({
            @Mapping(source="userId",target = "userId" ),
            @Mapping(source="username",target = "username" ),
            @Mapping(source = "password", target = "password" ),
            @Mapping(source="firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName" ),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "authorities", target = "authorities"),
            @Mapping(target = "creationDateTime" ,ignore = true),
            @Mapping(target = "creationUserId",ignore = true),
            @Mapping(target = "modificationDateTime",ignore = true ),
            @Mapping(target = "modificationUserId",ignore = true ),
            @Mapping( target = "enabled" ,ignore = true),
            @Mapping( target = "creationUser",ignore = true),
            @Mapping(target = "createdUsers" ,ignore = true),
            @Mapping(target = "modificationUser",ignore = true),
            @Mapping(target = "modifiedUsers",ignore = true)
    })
    public abstract User create(CreateUserRequest request);
}
