package com.example.spring_security_demo.persistance.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="role_id")
    private Integer roleId;
    @Column(name="role_name")
    private String roleName;

    @Transient
    private RoleName roleNameEnum;
    @OneToMany(mappedBy = "role")
    private Set<UserRole> users= new HashSet<>();

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        switch (roleName){
            case "SYSTEM_ADMIN":
                this.roleNameEnum=RoleName.SYSTEM_ADMIN;
                break;
            case "USER_ADMIN":
                this.roleNameEnum=RoleName.USER_ADMIN;
                break;
            case "BOOK_ADMIN":
                this.roleNameEnum=RoleName.BOOK_ADMIN;
                break;
            case "AUDITHOR":
                this.roleNameEnum=RoleName.AUDITHOR;
                break;
            default:
                this.roleNameEnum=RoleName.NONE;
                break;
        }
        this.roleName = roleName;
    }

    public Set<UserRole> getUser() {
        return users;
    }

    public void setUser(Set<UserRole> user) {
        this.users = user;
    }

    public RoleName getRoleNameEnum() {
        return roleNameEnum;
    }
}
