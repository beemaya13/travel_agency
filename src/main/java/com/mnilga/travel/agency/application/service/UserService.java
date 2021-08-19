package com.mnilga.travel.agency.application.service;

import com.mnilga.travel.agency.application.dto.UserDto;
import com.mnilga.travel.agency.application.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    boolean addUser(User user);             ////UserDto create(User user);  +  UserDto update(User user)
    UserDto getUserById(String id);         //UserDto getUserById(UUID id);
    UserDto getUserByEmail(String email);
    List<UserDto> getAllUsers();
    void deleteUser(UUID id);
}
