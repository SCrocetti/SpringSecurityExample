package com.example.spring_security_demo.persistance.entity;

import javax.persistence.Column;
import java.io.Serializable;
public class UserRolePk implements Serializable {
    @Column(name="role_id")
    private Integer roleId;
    @Column(name="user_id")
    private Integer userId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}