package com.example.spring_security_demo.persistance.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "roles_permissions")
public class RolePermission {
    @EmbeddedId
    private RolePermissionPk id;
    @CreatedDate
    @Column(name="creation_date_time")
    private LocalDateTime creationDateTime;
    @Column(name="creation_user")
    private Integer creationUser;
    @LastModifiedDate
    @Column(name="modification_date_time")
    private LocalDateTime modificationDateTime;
    @Column(name="modification_user")
    private Integer modificationUser;
    private boolean enabled = true;


    @ManyToOne
    @JoinColumn(name = "role_id",insertable = false,updatable = false)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "permission_id",insertable = false,updatable = false)
    private Permission permission;
}
