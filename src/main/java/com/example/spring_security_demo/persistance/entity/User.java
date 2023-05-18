package com.example.spring_security_demo.persistance.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Integer userId;

    @Column(name="user_name")
    private String username;
    private String password;

    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;

    private String email;
    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private Set<UserRole> authorities = new HashSet<>();

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
    @OneToMany(mappedBy = "creationUser",fetch = FetchType.EAGER)
    private List<User> createdUsers =new ArrayList<User>();

    @ManyToOne
    @JoinColumn(name = "modification_user_id",insertable = false,updatable = false)
    private User modificationUser;
    @OneToMany(mappedBy = "modificationUser",fetch = FetchType.EAGER)
    private List<User> modifiedUsers= new ArrayList<User>();
    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Set<UserRole> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return enabled;
    }

    @Override
    public boolean isAccountNonLocked() {
        return enabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return enabled;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAuthorities(Set<UserRole> authorities) {
        this.authorities = authorities;
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

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public User getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(User creationUser) {
        this.creationUser = creationUser;
    }

    public List<User> getCreatedUsers() {
        return createdUsers;
    }

    public void setCreatedUsers(List<User> createdUsers) {
        this.createdUsers = createdUsers;
    }

    public User getModificationUser() {
        return modificationUser;
    }

    public void setModificationUser(User modificationUser) {
        this.modificationUser = modificationUser;
    }

    public List<User> getModifiedUsers() {
        return modifiedUsers;
    }

    public void setModifiedUsers(List<User> modifiedUsers) {
        this.modifiedUsers = modifiedUsers;
    }
}