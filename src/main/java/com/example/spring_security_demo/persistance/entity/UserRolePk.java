package com.example.spring_security_demo.persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.io.Serializable;
@Getter
@Setter
public class UserRolePk implements Serializable {
    @Column(name="role_id")
    private Integer roleId;
    @Column(name="user_id")
    private Integer userId;
}