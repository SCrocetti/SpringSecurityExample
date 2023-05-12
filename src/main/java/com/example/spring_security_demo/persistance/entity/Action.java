package com.example.spring_security_demo.persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "actions")
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="action_id")
    private Integer actionId;

    @Column(name="action_name")
    private String actionName;

    @OneToMany(mappedBy = "action")
    private List<Permission> permissions;
}
