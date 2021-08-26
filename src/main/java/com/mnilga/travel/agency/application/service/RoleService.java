package com.mnilga.travel.agency.application.service;

import com.mnilga.travel.agency.application.dto.RoleDto;
import com.mnilga.travel.agency.application.dto.UserDto;
import com.mnilga.travel.agency.application.model.Role;
import com.mnilga.travel.agency.application.model.User;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface RoleService {
    RoleDto create(Role role);
    RoleDto readById(UUID id);
    RoleDto update(Role role);
    void delete(UUID id);
    List<RoleDto> getAllRoles();
    Role findByName(String name);

}
