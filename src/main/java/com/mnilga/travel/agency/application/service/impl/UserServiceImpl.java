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
import java.util.Map;
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
    public UserDto create(User user) {
        return null;
    }

    @Override
    public UserDto readById(UUID id) {
        return null;
    }

    @Override
    public UserDto update(User user) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public UserDto patch(Map<String, Object> fields, UUID id) {
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return null;
    }
}
