package com.mnilga.travel.agency.application.service.impl;


import com.mnilga.travel.agency.application.dto.UserDto;
import com.mnilga.travel.agency.application.exceptions.ResourceNotFoundException;
import com.mnilga.travel.agency.application.model.Role;
import com.mnilga.travel.agency.application.model.User;
import com.mnilga.travel.agency.application.repository.UserRepository;
import com.mnilga.travel.agency.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ConversionService service;
    private RoleServiceImpl roleService;

    @Autowired
    public void setService(ConversionService service) {
        this.service = service;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setRoleService(RoleServiceImpl roleService) {
        this.roleService = roleService;
    }

    @Override
    public UserDto create(User user) {
        Role role = roleService.findByName("USER");
        user.setRole(role);
        User newUser = userRepository.save(user);
        return service.convert(newUser, UserDto.class);
    }

    @Override
    public UserDto readById(UUID id) {
        User user = findUserById(id);
        return service.convert(user, UserDto.class);
    }

    private User findUserById(UUID id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new ResourceNotFoundException("User with id = " + id + " not found");
        }
        return optionalUser.get();
    }

    @Override
    public UserDto update(User user) {
        if (user == null) {
            throw new RuntimeException("User can't be null");
        }

        Optional.ofNullable(userRepository.findByEmail(user.getEmail()))
                .orElseThrow(() -> new ResourceNotFoundException("User with email = " + user.getEmail() + " does not exist!"));

        User updatedUser = userRepository.save(user);
        return service.convert(updatedUser, UserDto.class);
    }

    @Override
    public void delete(UUID id) {
        User user = findUserById(id);
        userRepository.delete(user);
    }

    @Override
    public UserDto patch(Map<String, Object> fields, UUID id) {
        User user = findUserById(id);
        fields.forEach((k, v) -> {
            Field field = ReflectionUtils.findField(User.class, k);
            field.setAccessible(true);
            ReflectionUtils.setField(field, user, v);
        });
        User patchedUser = userRepository.save(user);
        return service.convert(patchedUser, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> service.convert(user, UserDto.class))
                .collect(Collectors.toList());
    }


//    public void testDto(){
//        User user = new User();
//        user.setId(UUID.randomUUID());
//        user.setEmail("mnilga@gmail.com");
//        user.setFirstName("Maya");
//        user.setLastName("Nilga");
//        user.setSex(User.Sex.FEMALE);
//        user.setRole(new Role());
//        UserDto userDto = service.convert(user, UserDto.class);
//        System.out.println(userDto);
//    }

}
