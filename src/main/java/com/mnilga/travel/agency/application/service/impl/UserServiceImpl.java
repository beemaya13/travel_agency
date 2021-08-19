package com.mnilga.travel.agency.application.service.impl;

import com.mnilga.travel.agency.application.model.User;
import com.mnilga.travel.agency.application.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }
}
