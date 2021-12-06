package com.mnilga.travel.agency.application.service.impl;


import com.mnilga.travel.agency.application.dto.UserDto;
import com.mnilga.travel.agency.application.exceptions.ResourceNotFoundException;
import com.mnilga.travel.agency.application.model.Address;
import com.mnilga.travel.agency.application.model.Role;
import com.mnilga.travel.agency.application.model.User;
import com.mnilga.travel.agency.application.repository.UserRepository;
import com.mnilga.travel.agency.application.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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

    private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);
    private UserRepository userRepository;
    private ConversionService service;
    private RoleServiceImpl roleService;
    private AddressServiceImpl addressService;

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

    @Autowired
    public void setAddressService(AddressServiceImpl addressService) {
        this.addressService = addressService;
    }

    @Override
    public UserDto create(User user) {
        LOGGER.info("Starting to create user");
        if (user == null) {
            throw new RuntimeException("User can't be null");
        }
        getRoleFromUser(user);
        getAddressFromUser(user);
        User newUser = userRepository.save(user);
        LOGGER.info("User is created");
        return service.convert(newUser, UserDto.class);
    }

    @Override
    public UserDto readById(UUID id) {
        User user = findUserById(id);
        return service.convert(user, UserDto.class);

    }

    @Override
    public User findUserById(UUID id) {
        LOGGER.info("Starting to find user with id " + id);
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new ResourceNotFoundException("User with id = " + id + " not found");
        }
        LOGGER.info("User with id " + id + " found");
        return optionalUser.get();
    }

    @Override
    public UserDto update(User user) {
        LOGGER.warn("Starting to update user with id + " + user.getId());
        if (user == null) {
            throw new RuntimeException("User can't be null");
        }

        Optional.ofNullable(userRepository.findByEmail(user.getEmail()))
                .orElseThrow(() -> new ResourceNotFoundException("User with email = " + user.getEmail() + " does not exist!"));

        getRoleFromUser(user);
        getAddressFromUser(user);
        User updatedUser = userRepository.save(user);
        LOGGER.info("User with id + " + user.getId() + " is updated");
        return service.convert(updatedUser, UserDto.class);
    }

    @Override
    @CacheEvict   // to delete deleted users from cache
    public void delete(UUID id) {
        LOGGER.warn("Starting to delete user with id " + id);
        userRepository.deleteById(id);
        LOGGER.info("User with id " + id + " is deleted");
    }

    @Override
    public UserDto patch(Map<String, Object> fields, UUID id) {
        LOGGER.warn("Started patching user with id + " + id);
        User user = findUserById(id);
        fields.forEach((k, v) -> {
            Field field = ReflectionUtils.findField(User.class, k);
            field.setAccessible(true);
            ReflectionUtils.setField(field, user, v);
        });
        User patchedUser = userRepository.save(user);
        LOGGER.info("User with id + " + user.getId() + " is patched");
        return service.convert(patchedUser, UserDto.class);
    }

    @Override
    @Cacheable(value = "users-cache")
    public List<UserDto> getAllUsers() {
        LOGGER.info("Starting to get all users");
        List<User> users = userRepository.findAll();
        LOGGER.info("All users are got");
        return users.stream()
                .map(user -> service.convert(user, UserDto.class))
                .collect(Collectors.toList());
    }

    private void getRoleFromUser(User userWithRole) {
        LOGGER.info("Starting to get role from user by name");
        String roleName = userWithRole.getRole().getName();
        Role role;
        try {
            role = roleService.findByName(roleName);
        } catch (ResourceNotFoundException exception) {
            LOGGER.error("No matching roles found. Setting default user role");
            role = roleService.findByName("USER");
            LOGGER.info("USER role is set");
            userWithRole.setRole(role);
            return;
        }
        userWithRole.setRole(role);
        LOGGER.info("Role is set");
    }

    private void getAddressFromUser(User userWithAddress) {
        UUID addressId = userWithAddress.getAddress().getId();
        Address address = addressService.findById(addressId);
        userWithAddress.setAddress(address);
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
