package com.example.spring_security_demo.persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
@Getter
@Setter
public class RolePermissionPk {
    @Column(name="role_id")
    private Integer roleId;
    @Column(name="permission_id")
    private Integer permissionId;
}
