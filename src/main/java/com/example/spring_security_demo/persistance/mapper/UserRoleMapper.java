package com.example.spring_security_demo.persistance.mapper;

import com.example.spring_security_demo.persistance.crud.UserRoleCrudRepository;
import com.example.spring_security_demo.persistance.entity.Role;
import com.example.spring_security_demo.persistance.entity.RoleName;
import com.example.spring_security_demo.persistance.entity.UserRole;
import com.example.spring_security_demo.persistance.entity.UserRolePk;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;
@Component
@Mapper(componentModel = "spring",uses={RoleMapper.class})
public class UserRoleMapper {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserRoleCrudRepository userRoleCrudRepository;
    public UserRole toUserRole(Integer userId,String authority){
        Role role=roleMapper.toRole(authority);
        UserRole userRole=new UserRole();
        userRole.setId(new UserRolePk(role.getRoleId(),userId));
        if(!role.getRoleName().equals(RoleName.NONE)){
            return userRoleCrudRepository.findById(new UserRolePk(role.getRoleId(), userId)).
                    orElse(userRole);
        }
        return userRole;
    }
    public Set<UserRole> toUserRole(Integer userId,Set<String> authorities){
        return authorities
                .stream()
                .map(auth->toUserRole(userId,auth))
                .collect(Collectors.toSet());
    }
}
