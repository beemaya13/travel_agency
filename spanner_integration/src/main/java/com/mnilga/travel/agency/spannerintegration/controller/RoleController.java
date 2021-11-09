package com.mnilga.travel.agency.spannerintegration.controller;

import com.mnilga.travel.agency.spannerintegration.dto.RoleDto;
import com.mnilga.travel.agency.spannerintegration.model.Role;
import com.mnilga.travel.agency.spannerintegration.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    private RoleService roleService;

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid Role role){
        if(role == null){
            return new ResponseEntity<>("Role can't be null", HttpStatus.BAD_REQUEST);
        }
        RoleDto createdRoleDto;
        try {
            createdRoleDto = roleService.create(role);
        }catch (Exception e) {
            return new ResponseEntity<>("Role with such name already exists!", HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(createdRoleDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> readById(@PathVariable String id){
        if(id == null){
            return new ResponseEntity<>("Role can't be null", HttpStatus.BAD_REQUEST);
        }

        RoleDto roleDto = roleService.readById(id);
        if(roleDto == null){
            return new ResponseEntity<>("Role with such id not found!", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(roleDto, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid Role role){
        if(role == null){
            return new ResponseEntity<>("Role can't be null", HttpStatus.BAD_REQUEST);
        }
        RoleDto updatedRole;
        try {
            updatedRole = roleService.update(role);
        }catch (Exception e) {
            return new ResponseEntity<>("Role with such name already exists!", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(updatedRole, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        RoleDto roleDto = roleService.readById(id);
        if(roleDto == null){
            return new ResponseEntity<>("Role with such id not found!", HttpStatus.NOT_FOUND);
        }
        roleService.delete(id);
        return new ResponseEntity<>("Role is successfully deleted!", HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<?> getAllRoles(){
        List<RoleDto> roleDtoList = roleService.getAllRoles();
        if(roleDtoList.isEmpty()){
            return new ResponseEntity<>("There are no roles to display!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(roleDtoList, HttpStatus.OK);
    }

}
