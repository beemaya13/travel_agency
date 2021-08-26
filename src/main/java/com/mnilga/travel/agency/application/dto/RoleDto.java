package com.mnilga.travel.agency.application.dto;

import java.util.UUID;

public class RoleDto {
    private UUID roleId;
    private String name;

    public UUID getRoleId() {
        return roleId;
    }

    public void setRoleId(UUID roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RoleDto{" +
                "roleId='" + roleId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
