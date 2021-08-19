package com.mnilga.travel.agency.application.service;

import com.mnilga.travel.agency.application.model.User;

import java.util.List;

public interface UserService {                  /////add DTO!!!!
    boolean addUser(User user);
    User getUserById(Long id);
    User getUserByEmail(String email);
    List<User> getAllUsers();
    void deleteUser(Long id);
}
