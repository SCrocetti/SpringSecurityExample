package com.example.spring_security_demo.persistance.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "modules")
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="module_id")
    private Integer moduleId;

    @Column(name="module_name")
    private String moduleName;
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

    @OneToMany(mappedBy = "module")
    private List<Permission> permissions;

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public Integer getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(Integer creationUser) {
        this.creationUser = creationUser;
    }

    public LocalDateTime getModificationDateTime() {
        return modificationDateTime;
    }

    public void setModificationDateTime(LocalDateTime modificationDateTime) {
        this.modificationDateTime = modificationDateTime;
    }

    public Integer getModificationUser() {
        return modificationUser;
    }

    public void setModificationUser(Integer modificationUser) {
        this.modificationUser = modificationUser;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
