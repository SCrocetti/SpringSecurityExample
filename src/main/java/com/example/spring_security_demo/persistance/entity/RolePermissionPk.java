package com.example.spring_security_demo.persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
public class RolePermissionPk {
    @Column(name="role_id")
    private Integer roleId;
    @Column(name="permission_id")
    private Integer permissionId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }
}
