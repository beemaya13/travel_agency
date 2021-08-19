package com.mnilga.travel.agency.application.service.impl;

import com.mnilga.travel.agency.application.dto.RoleDto;
import com.mnilga.travel.agency.application.model.Role;
import com.mnilga.travel.agency.application.model.User;
import com.mnilga.travel.agency.application.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class RoleServiceImpl implements RoleService {

    private ConversionService service;

    @Autowired
    public void setService(ConversionService service) {
        this.service = service;
    }

    public void test(){
        Role role = new Role();
        role.setId(UUID.randomUUID());
        role.setName("Admin");
        RoleDto roleDto = new RoleDto();
        roleDto = service.convert(role, RoleDto.class);
        System.out.println(roleDto);
    }


    @Override
    public boolean addRole(Role role) {
        return false;
    }

    @Override
    public RoleDto getRoleById(String id) {
        return null;
    }

    @Override
    public List<RoleDto> getAllRoles() {
        return null;
    }

    @Override
    public void deleteRole(UUID id) {

    }
}
