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
    public ResponseEntity<?> create(@RequestBody @Valid User user) {
        UserDto createdUserDto;
        try {
            createdUserDto = userService.create(user);
        } catch (Exception e) {
            return new ResponseEntity<>("User with such email already exists!", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> readById(@PathVariable("id") UUID id) {
        UserDto userDto = userService.readById(id);
        if (userDto == null) {
            return new ResponseEntity<>("User with such id not found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid User user) {
        UserDto updatedUser;
        try {
            updatedUser = userService.update(user);
        } catch (Exception e) {
            return new ResponseEntity<>("User with such email already exists!", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") UUID id) {
        try {
            userService.readById(id);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>("User with such id not found!", HttpStatus.NOT_FOUND);
        }
        userService.delete(id);
        return new ResponseEntity<>("User is successfully deleted!", HttpStatus.NO_CONTENT);

    }

    @Autowired
    ApplicationContext applicationContext;

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        List<UserDto> userDtoList = userService.getAllUsers();
        if (userDtoList.isEmpty()) {
            return new ResponseEntity<>("There are no users to display!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userDtoList, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserDto> patch(@RequestBody Map<String, Object> fields, @PathVariable UUID id) {
        UserDto userDto = userService.patch(fields, id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

}
