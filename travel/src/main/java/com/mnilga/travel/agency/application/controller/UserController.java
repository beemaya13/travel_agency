package com.mnilga.travel.agency.application.controller;

import com.mnilga.travel.agency.application.dto.UserDto;
import com.mnilga.travel.agency.application.exceptions.ResourceNotFoundException;
import com.mnilga.travel.agency.application.model.User;
import com.mnilga.travel.agency.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody @Valid User user) {
        UserDto createdUserDto = userService.create(user);
        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> readById(@PathVariable("id") UUID id) {
        UserDto userDto = userService.readById(id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<UserDto> update(@RequestBody @Valid User user) {
        UserDto updatedUser = userService.update(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") UUID id) {
        userService.delete(id);
        return new ResponseEntity<>("User is successfully deleted!", HttpStatus.NO_CONTENT);

    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> userDtoList = userService.getAllUsers();
        return new ResponseEntity<>(userDtoList, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserDto> patch(@RequestBody Map<String, Object> fields, @PathVariable UUID id) {
        UserDto userDto = userService.patch(fields, id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

}
