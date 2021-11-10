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

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

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
    void creteTest() {
        User user = createUser();
        UserDto expected = createUserDto();

        when(roleService.findByName(ROLE_ADMIN))
            .thenReturn(createRole());
     //   when(addressService.findByCountryAndCityAndStreetAndHouseNumberAndFlatNumberAndZipcode(
     //       COUNTRY, CITY, STREET, HOUSE_NUMBER, FLAT_NUMBER, ZIPCODE
     //   )).thenReturn(createAddress());
        when(userRepository.save(user))
            .thenReturn(user);

        UserDto actual = userService.create(user);

        assertUserDto(expected, actual);

        verify(roleService).findByName(ROLE_ADMIN);
     //   verify(addressService).findByCountryAndCityAndStreetAndHouseNumberAndFlatNumberAndZipcode(
      //      COUNTRY, CITY, STREET, HOUSE_NUMBER, FLAT_NUMBER, ZIPCODE);
        verify(userRepository).save(user);

        verifyNoMoreInteractions(roleService, addressService, userRepository);
    }

    @Test
    void creteShouldThrowExceptionTest() {
        assertThrows(RuntimeException.class, () -> userService.create(null), "User can't be null");
    }




}