package com.example.spring_security_demo.persistance.mapper;

import com.example.spring_security_demo.persistance.crud.UserRoleCrudRepository;
import com.example.spring_security_demo.persistance.entity.UserRole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;

import java.util.Set;
import java.util.stream.Collectors;
@Mapper(componentModel = "spring", uses = RoleMapper.class)
public abstract class UserRoleMapper {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserRoleCrudRepository userRoleCrudRepository;

    @Mappings({
            @Mapping(source = "authority", target = "id.roleId",qualifiedByName = "authorityToRoleId"),
            @Mapping(source = "userId",target = "id.userId"),
            @Mapping(target = "creationDateTime" ,ignore = true),
            @Mapping(target = "creationUserId",ignore = true),
            @Mapping(target = "modificationDateTime",ignore = true ),
            @Mapping(target = "modificationUserId",ignore = true ),
            @Mapping( target = "enabled" ,ignore = true),
            @Mapping( target = "creationUser",ignore = true),
            @Mapping(target = "createdUsers" ,ignore = true),
            @Mapping(target = "modificationUser",ignore = true),
            @Mapping(target = "modifiedUsers",ignore = true),
            @Mapping(source = "authority", target = "role")

    })
    public abstract UserRole toUserRole(@Param("userId") Integer userId, String authority);
    public Set<UserRole> toUserRoles(@Param("userId")Integer userId, Set<String> authorities) {
        return authorities.stream()
                .map(authority -> toUserRole(userId, authority))
                .collect(Collectors.toSet());
    }
    @Named("authorityToRoleId")
    protected Integer authorityToRoleId(String authority){
        return roleMapper.toRole(authority).getRoleId();
    }

}
