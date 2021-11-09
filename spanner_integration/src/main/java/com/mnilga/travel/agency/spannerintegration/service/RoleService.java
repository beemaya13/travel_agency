package com.mnilga.travel.agency.spannerintegration.service;

import com.mnilga.travel.agency.spannerintegration.dto.RoleDto;
import com.mnilga.travel.agency.spannerintegration.model.Role;

import java.util.List;

public interface RoleService {
    RoleDto create(Role role);
    RoleDto readById(String id);
    RoleDto update(Role role);
    void delete(String id);
    List<RoleDto> getAllRoles();
    Role findByName(String name);

}
