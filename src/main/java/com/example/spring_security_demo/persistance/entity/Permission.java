package com.example.spring_security_demo.persistance.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "permissions")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="permission_id")
    private Integer permissionId;
    @Column(name="role_id")
    private Integer roleId;
    @Column(name="module_id")
    private Integer moduleId;
    @Column(name="action_name")
    private String actionName;
    @Column(name="permission_name")
    private String permissionName;

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

    @OneToMany(mappedBy = "permission")
    private List<RolePermission> roles;

    @ManyToOne
    @JoinColumn(name = "module_id",insertable = false,updatable = false)
    private Module module;

    private Action action;

    public void setActionId(String actionName) {
        this.actionName = actionName;
        switch (actionName){
            case "READ":
                action=Action.READ;
                break;
            case "WRITE":
                action=Action.WRITE;
                break;
            case "OVERWRITE":
                action=Action.OVERWRITE;
                break;
            case "DELETE":
                action=Action.DELETE;
                break;
            default:
                action=Action.NONE;
                break;
        }
    }
}
