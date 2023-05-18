package com.example.spring_security_demo.persistance.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users_roles")
public class UserRole implements GrantedAuthority {
    @EmbeddedId
    private UserRolePk id;

    @CreatedDate
    @Column(name="creation_date_time")
    private LocalDateTime creationDateTime;
    @Column(name="creation_user_id")
    private Integer creationUserId;
    @LastModifiedDate
    @Column(name="modification_date_time")
    private LocalDateTime modificationDateTime;
    @Column(name="modification_user_id")
    private Integer modificationUserId;
    private boolean enabled = true;

    @ManyToOne
    @JoinColumn(name = "creation_user_id",insertable = false,updatable = false)
    private User creationUser;

    @ManyToOne
    @JoinColumn(name = "modification_user_id",insertable = false,updatable = false)
    private User modificationUser;

    @ManyToOne
    @JoinColumn(name = "user_id",insertable = false,updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id",insertable = false,updatable = false)
    private Role role;

    @Override
    public  String getAuthority(){
        return this.role.getRoleNameEnum().toString();
    }

    public UserRolePk getId() {
        return id;
    }

    public void setId(UserRolePk id) {
        this.id = id;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public Integer getCreationUserId() {
        return creationUserId;
    }

    public void setCreationUserId(Integer creationUserId) {
        this.creationUserId = creationUserId;
    }

    public LocalDateTime getModificationDateTime() {
        return modificationDateTime;
    }

    public void setModificationDateTime(LocalDateTime modificationDateTime) {
        this.modificationDateTime = modificationDateTime;
    }

    public Integer getModificationUserId() {
        return modificationUserId;
    }

    public void setModificationUserId(Integer modificationUserId) {
        this.modificationUserId = modificationUserId;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(User creationUser) {
        this.creationUser = creationUser;
    }

    public User getModificationUser() {
        return modificationUser;
    }

    public void setModificationUser(User modificationUser) {
        this.modificationUser = modificationUser;
    }
}