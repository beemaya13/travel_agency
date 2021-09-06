package com.mnilga.travel.agency.application.service;

import com.mnilga.travel.agency.application.dto.RoleDto;
import com.mnilga.travel.agency.application.model.Role;

import java.util.List;
import java.util.UUID;

public interface RoleService {
    RoleDto create(Role role);
    RoleDto readById(UUID id);
    RoleDto update(Role role);
    void delete(UUID id);
    List<RoleDto> getAllRoles();
    Role findByName(String name);

}
