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

@Mapper(componentModel = "spring",uses = UserRoleMapper.class)
public abstract  class UserSaveMapper {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @BeanMapping(nullValueCheckStrategy = ALWAYS, nullValuePropertyMappingStrategy = IGNORE)
    @Mapping(source = "authorities", target = "authorities", qualifiedByName = "stringToUserRole")
    public abstract void updateAuthorities(UpdateUserAuthoritiesRequest request, @MappingTarget User user);
    @BeanMapping(nullValueCheckStrategy = ALWAYS, nullValuePropertyMappingStrategy = IGNORE)
    public abstract void updateInfo(UpdateUserInfoRequest request, @MappingTarget User user);

    @Mapping(source = "userId",target = "userId")
    @Mapping(source = "authorities",target = "authorities", qualifiedByName = "stringToRole")
    public abstract User create(CreateUserRequest request);
    @Named("stringToRole")
    protected Set<UserRole> stringToUserRole(Integer userId, Set<String> authorities) {
        if (authorities != null) {
            return userRoleMapper.toUserRole(userId,authorities);
        }
        return new HashSet<>();
    }
}
