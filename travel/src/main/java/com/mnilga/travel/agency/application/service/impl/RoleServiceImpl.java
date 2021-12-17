package com.mnilga.travel.agency.application.service.impl;

import com.mnilga.travel.agency.application.dto.RoleDto;
import com.mnilga.travel.agency.application.exceptions.ResourceNotFoundException;
import com.mnilga.travel.agency.application.model.Role;
import com.mnilga.travel.agency.application.repository.RoleRepository;
import com.mnilga.travel.agency.application.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;
    private ConversionService service;

    @Autowired
    public void setService(ConversionService service) {
        this.service = service;
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleDto create(Role role) {
        if (role == null) {
            throw new RuntimeException("Role can't be null");
        }
        Role newRole = roleRepository.save(role);
        return service.convert(newRole, RoleDto.class);
    }

    @Override
    public RoleDto readById(UUID id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role with id=" + id + " not found!"));
        return service.convert(role, RoleDto.class);
    }

    @Override
    public RoleDto update(Role role) {
        if (role == null) {
            throw new RuntimeException("Role can't be null");
        }

        Optional.ofNullable(roleRepository.findByName(role.getName()))
                .orElseThrow(() -> new ResourceNotFoundException("Role with name = " + role.getName() + " does not exist!"));

        Role updatedRole = roleRepository.save(role);
        return service.convert(updatedRole, RoleDto.class);
    }

    @Override
    public void delete(UUID id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role with id = " + id + " not found!"));
        roleRepository.delete(role);
    }

    @Override
    public List<RoleDto> getAllRoles() {
        List<Role> roles = roleRepository.findAll();
        return roles.stream()
                .map(role -> service.convert(role, RoleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Cacheable(value = "roles-cache")
    public Role findByName(String name) {
        return roleRepository.findByName(name).orElseThrow(() -> {
            throw new ResourceNotFoundException("Role with name =" + name + " does not exist!");
        });
    }

//    public void testDto(){
//        Role role = new Role();
//        role.setId(UUID.randomUUID());
//        role.setName("Admin");
//        RoleDto roleDto = service.convert(role, RoleDto.class);
//        System.out.println(roleDto);
//    }
}
