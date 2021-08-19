package com.mnilga.travel.agency.application.service;

import com.mnilga.travel.agency.application.dto.RoleDto;
import com.mnilga.travel.agency.application.model.Role;
import com.mnilga.travel.agency.application.model.User;

import java.util.List;
import java.util.UUID;

public interface RoleService {
    boolean addRole(Role role);         //RoleDto create(Role role);
    RoleDto getRoleById(String id);     //RoleDto getRoleById(UUID id);
    List<RoleDto> getAllRoles();
    void deleteRole(UUID id);
}
