package com.mnilga.travel.agency.application.service.impl;

import com.mnilga.travel.agency.application.dto.RoleDto;
import com.mnilga.travel.agency.application.model.Role;
import com.mnilga.travel.agency.application.model.User;
import com.mnilga.travel.agency.application.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;


@Service
public class RoleServiceImpl implements RoleService {

    private ConversionService service;

    @Autowired
    public void setService(ConversionService service) {
        this.service = service;
    }

    public void testDto(){
        Role role = new Role();
        role.setId(UUID.randomUUID());
        role.setName("Admin");
        RoleDto roleDto = service.convert(role, RoleDto.class);
        System.out.println(roleDto);
    }


    @Override
    public RoleDto create(Role role) {
        return null;
    }

    @Override
    public RoleDto readById(UUID id) {
        return null;
    }

    @Override
    public RoleDto update(Role role) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public RoleDto patch(Map<String, Object> fields, UUID id) {
        return null;
    }

    @Override
    public List<RoleDto> getAllRoles() {
        return null;
    }
}
