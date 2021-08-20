package com.mnilga.travel.agency.application.service.impl;

import com.mnilga.travel.agency.application.dto.RoleDto;
import com.mnilga.travel.agency.application.dto.UserDto;
import com.mnilga.travel.agency.application.model.Role;
import com.mnilga.travel.agency.application.model.User;
import com.mnilga.travel.agency.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private ConversionService service;

    @Autowired
    public void setService(ConversionService service) {
        this.service = service;
    }

    public void testDto(){
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setEmail("mnilga@gmail.com");
        user.setFirstName("Maya");
        user.setLastName("Nilga");
        user.setSex(User.Sex.FEMALE);
        user.setRole(new Role());

        UserDto userDto = service.convert(user, UserDto.class);
        System.out.println(userDto);
    }




    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public UserDto getUserById(String id) {
        return null;
    }

    @Override
    public UserDto getUserByEmail(String email) {
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return null;
    }

    @Override
    public void deleteUser(UUID id) {

    }
}
