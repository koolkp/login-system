package com.kamakhya.entity;

import javax.persistence.*;

@Entity
@Table(name = "action_type")
public class ActionType {

    @Id
    @GeneratedValue
    @Column
    private Integer id;

    @Column
    private String accessLevel;

    public ActionType() {
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
