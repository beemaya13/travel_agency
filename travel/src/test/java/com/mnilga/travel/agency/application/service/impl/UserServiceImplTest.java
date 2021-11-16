package com.mnilga.travel.agency.application.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.convert.ConversionService;

import com.mnilga.travel.agency.application.dto.UserDto;
import com.mnilga.travel.agency.application.model.User;
import com.mnilga.travel.agency.application.repository.UserRepository;
import com.mnilga.travel.agency.application.util.TestDataFactory;

import static org.junit.jupiter.api.Assertions.*;
import static com.mnilga.travel.agency.application.util.TestDataFactory.*;
import static com.mnilga.travel.agency.application.util.AssertUtils.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;
    @Spy
    private ConversionService conversionService;
    @Mock
    private RoleServiceImpl roleService;
    @Mock
    private AddressServiceImpl addressService;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void createTest() {
        User user = createUser();
        UserDto expected = createUserDto();
        UserDto actual = userService.create(user);

        when(roleService.findByName(ROLE_ADMIN))
            .thenReturn(createRole());

        when(addressService.findById(ID)).thenReturn(createAddress());

        doReturn(user).when(userRepository).save(any(User.class));
        User u = userRepository.save(user);

//        when(userRepository.save(user))
//            .thenReturn(user);


        assertUserDto(expected, actual);

        verify(roleService).findByName(ROLE_ADMIN);
        verify(addressService).findById(ID);
        verify(userRepository).save(user);

        verifyNoMoreInteractions(roleService, addressService, userRepository);
    }

    @Test
    void createShouldThrowExceptionTest() {
        assertThrows(RuntimeException.class, () -> userService.create(null), "User can't be null");
    }




}