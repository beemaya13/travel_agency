package com.mnilga.travel.agency.application.service;

import com.mnilga.travel.agency.application.dto.UserDto;
import com.mnilga.travel.agency.application.model.User;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface UserService {
    UserDto create(User user);
    UserDto readById(UUID id);
    UserDto update(User user);
    void delete(UUID id);
    UserDto patch(Map<String, Object> fields, UUID id);
    List<UserDto> getAllUsers();
    User findUserById(UUID id);
    //UserDto getUserByEmail(String email);
}
