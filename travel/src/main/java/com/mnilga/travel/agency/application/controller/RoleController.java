package com.mnilga.travel.agency.application.controller;

import com.mnilga.travel.agency.application.dto.RoleDto;
import com.mnilga.travel.agency.application.model.Role;
import com.mnilga.travel.agency.application.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    private RoleService roleService;

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<RoleDto> create(@RequestBody @Valid Role role){
      RoleDto createdRoleDto = roleService.create(role);
      return new ResponseEntity<>(createdRoleDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDto> readById(@PathVariable UUID id){
      RoleDto roleDto = roleService.readById(id);
       return new ResponseEntity<>(roleDto, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<RoleDto> update(@RequestBody @Valid Role role){
       RoleDto updatedRole = roleService.update(role);
       return new ResponseEntity<>(updatedRole, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id){
        roleService.delete(id);
        return new ResponseEntity<>("Role is successfully deleted!", HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<RoleDto>> getAllRoles(){
        List<RoleDto> roleDtoList = roleService.getAllRoles();
        return new ResponseEntity<>(roleDtoList, HttpStatus.OK);
    }

}
