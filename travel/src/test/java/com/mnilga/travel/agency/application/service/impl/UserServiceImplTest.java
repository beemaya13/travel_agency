package com.mnilga.travel.agency.application.service.impl;

import com.mnilga.travel.agency.application.converter.AddressConverterToDto;
import com.mnilga.travel.agency.application.converter.RoleConverterToDto;
import com.mnilga.travel.agency.application.converter.UserConverterToDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.convert.ConversionService;

import com.mnilga.travel.agency.application.dto.UserDto;
import com.mnilga.travel.agency.application.model.User;
import com.mnilga.travel.agency.application.repository.UserRepository;
import com.mnilga.travel.agency.application.util.TestDataFactory;
import org.springframework.core.convert.support.GenericConversionService;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static com.mnilga.travel.agency.application.util.TestDataFactory.*;
import static com.mnilga.travel.agency.application.util.AssertUtils.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;
//    @Spy
    private GenericConversionService genericConversionService = new GenericConversionService();
    private ConversionService conversionService;
    @Mock
    private RoleServiceImpl roleService;
    @Mock
    private AddressServiceImpl addressService;

    @InjectMocks
    private UserServiceImpl userService;

    {
        UserConverterToDto userConverterToDto = new UserConverterToDto();
        userConverterToDto.setRoleConverterToDto(new RoleConverterToDto());
        userConverterToDto.setAddressConverterToDto(new AddressConverterToDto());
        genericConversionService.addConverter(userConverterToDto);
        conversionService = spy(genericConversionService);
    }

    @Test
    void createTest() {
        User user = createUser();
        UserDto expected = createUserDto();

        when(roleService.findByName(ROLE_ADMIN)).thenReturn(createRole());
        when(addressService.findById(ADDRESS_ID)).thenReturn(createAddress());
        when(userRepository.save(user)).thenReturn(user);

        UserDto actual = userService.create(user);
        assertUserDto(expected, actual);

        verify(roleService).findByName(ROLE_ADMIN);
        verify(addressService).findById(ADDRESS_ID);
        verify(userRepository).save(user);

        verifyNoMoreInteractions(roleService, addressService, userRepository);
    }

    @Test
    void createTest2() {
        User user = createUser();
        UserDto expected = createUserDto();

        doReturn(Optional.of(user))
                .when(userRepository)
                .findById(any(UUID.class));

        doReturn(user)
                .when(userRepository)
                .save(user);

        UserDto actual = userService.create(user);
        verify(userRepository).save(user);

        assertUserDto(expected, actual);

    }

    @Test
    void createShouldThrowExceptionTest() {
        assertThrows(RuntimeException.class, () -> userService.create(null), "User can't be null");
    }


}