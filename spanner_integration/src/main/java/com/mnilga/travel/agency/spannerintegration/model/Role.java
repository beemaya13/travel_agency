package com.mnilga.travel.agency.spannerintegration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ROLES")
public class Role extends Audit{

    @Column(nullable = false, unique = true)
    private String name;   // redo in enum

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
