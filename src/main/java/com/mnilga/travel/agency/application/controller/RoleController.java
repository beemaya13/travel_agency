package com.mnilga.travel.agency.application.controller;

import com.mnilga.travel.agency.application.dto.RoleDto;
import com.mnilga.travel.agency.application.dto.UserDto;
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
@RequestMapping("/roles")
public class RoleController {
    private RoleService roleService;

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<RoleDto> create(@RequestBody @Valid Role role){
        if(role == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        RoleDto createdRoleDto = roleService.create(role);
        return new ResponseEntity<>(createdRoleDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDto> readById(@PathVariable UUID id){
        if(id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        RoleDto roleDto = roleService.readById(id);
        if(roleDto == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(roleDto, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<RoleDto> update(@RequestBody @Valid Role role){
        if(role == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        RoleDto updatedRole = roleService.update(role);
        return new ResponseEntity<>(updatedRole, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RoleDto> delete(@PathVariable UUID id){
        RoleDto roleDto = roleService.readById(id);
        if(roleDto == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        roleService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<RoleDto>> getAllRoles(){
        List<RoleDto> roleDtoList = roleService.getAllRoles();
        if(roleDtoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(roleDtoList, HttpStatus.OK);
    }

}
