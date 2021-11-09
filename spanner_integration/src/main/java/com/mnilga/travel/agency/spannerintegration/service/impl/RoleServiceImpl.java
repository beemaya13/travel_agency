package com.mnilga.travel.agency.spannerintegration.service.impl;

import com.mnilga.travel.agency.spannerintegration.convertor.RoleMapper;
import com.mnilga.travel.agency.spannerintegration.dto.RoleDto;
import com.mnilga.travel.agency.spannerintegration.exceptions.ResourceNotFoundException;
import com.mnilga.travel.agency.spannerintegration.model.Role;
import com.mnilga.travel.agency.spannerintegration.repository.RoleRepository;
import com.mnilga.travel.agency.spannerintegration.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;


@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;
//    private ConversionService service;
//
//    @Autowired
//    public void setService(ConversionService service) {
//        this.service = service;
//    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleDto create(Role role) {
        Role newRole = roleRepository.save(role);
        //return service.convert(newRole, RoleDto.class);
        return RoleMapper.INSTANCE.roleToRoleDto(newRole);
    }

    @Override
    public RoleDto readById(String id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role with id=" + id + " not found!"));
        //return service.convert(role, RoleDto.class);
        return RoleMapper.INSTANCE.roleToRoleDto(role);
    }

    @Override
    public RoleDto update(Role role) {
        if (role == null) {
            throw new RuntimeException("Role can't be null");
        }

        Optional.ofNullable(roleRepository.findByName(role.getName()))
                .orElseThrow(() -> new ResourceNotFoundException("Role with name = " + role.getName() + " does not exist!"));

        Role updatedRole = roleRepository.save(role);
        return RoleMapper.INSTANCE.roleToRoleDto(updatedRole);
        //return service.convert(updatedRole, RoleDto.class);
    }

    @Override
    public void delete(String id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role with id = " + id + " not found!"));
        roleRepository.delete(role);
    }

    @Override
    public List<RoleDto> getAllRoles() {
        List<Role> roles = roleRepository.findAll();
        return roles.stream()
//                .map(role -> service.convert(role, RoleDto.class))
                .map(RoleMapper.INSTANCE::roleToRoleDto)
                .collect(Collectors.toList());
    }

    @Override
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
