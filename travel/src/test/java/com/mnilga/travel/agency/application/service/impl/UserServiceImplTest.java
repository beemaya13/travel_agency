package com.mnilga.travel.agency.application.service.impl;

import com.mnilga.travel.agency.application.converter.AddressConverterToDto;
import com.mnilga.travel.agency.application.converter.RoleConverterToDto;
import com.mnilga.travel.agency.application.converter.UserConverterToDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.convert.ConversionService;

import com.mnilga.travel.agency.application.dto.UserDto;
import com.mnilga.travel.agency.application.model.User;
import com.mnilga.travel.agency.application.repository.UserRepository;
import org.springframework.core.convert.support.GenericConversionService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.mnilga.travel.agency.application.util.TestDataFactory.createUser;
import static org.junit.jupiter.api.Assertions.*;
import static com.mnilga.travel.agency.application.util.TestDataFactory.*;
import static com.mnilga.travel.agency.application.util.AssertUtils.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepositoryMock;
    @Mock
    private RoleServiceImpl roleServiceMock;
    @Mock
    private AddressServiceImpl addressServiceMock;
    @InjectMocks
    private UserServiceImpl userService;

    private GenericConversionService genericConversionService = new GenericConversionService();
    private ConversionService conversionServiceSpy;
    private static User expectedUser;
    private static UserDto expectedUserDto;

    {
        UserConverterToDto userConverterToDto = new UserConverterToDto();
        userConverterToDto.setRoleConverterToDto(new RoleConverterToDto());
        userConverterToDto.setAddressConverterToDto(new AddressConverterToDto());
        genericConversionService.addConverter(userConverterToDto);
        conversionServiceSpy = spy(genericConversionService);
        expectedUser = createUser();
        expectedUserDto = createUserDto();
    }

    @Test
    void createTest() {
        when(roleServiceMock.findByName(ROLE_ADMIN)).thenReturn(createRole());
        when(addressServiceMock.findById(ADDRESS_ID)).thenReturn(createAddress());
        when(userRepositoryMock.save(expectedUser)).thenReturn(expectedUser);

        UserDto actualUserDto = userService.create(expectedUser);
        assertUserDto(expectedUserDto, actualUserDto);

        verify(roleServiceMock).findByName(ROLE_ADMIN);
        verify(addressServiceMock).findById(ADDRESS_ID);
        verify(userRepositoryMock).save(expectedUser);
        verifyNoMoreInteractions(roleServiceMock, addressServiceMock, userRepositoryMock);
    }


    @Test
    void createShouldThrowExceptionTest() {
        assertThrows(RuntimeException.class, () -> userService.create(null), "User can't be null");
    }

    @Test
    void readByIdTest() {
        when(userRepositoryMock.findById(USER_ID)).thenReturn(Optional.of(expectedUser));

        UserDto actualUserDto = userService.readById(USER_ID);
        assertUserDto(expectedUserDto, actualUserDto);

        verify(userRepositoryMock).findById(USER_ID);
        verifyNoMoreInteractions(userRepositoryMock);
    }

    @Test
    void updateTest() {
        //sequence of calling methods
        InOrder inOrder = inOrder(userRepositoryMock, roleServiceMock, addressServiceMock, userRepositoryMock);

        when(userRepositoryMock.findByEmail(EMAIL)).thenReturn(expectedUser);
        when(roleServiceMock.findByName(ROLE_ADMIN)).thenReturn(createRole());
        when(addressServiceMock.findById(ADDRESS_ID)).thenReturn(createAddress());
        when(userRepositoryMock.save(expectedUser)).thenReturn(expectedUser);

        UserDto actualUserDto = userService.update(expectedUser);
        assertUserDto(expectedUserDto, actualUserDto);

        inOrder.verify(userRepositoryMock).findByEmail(EMAIL);
        inOrder.verify(roleServiceMock).findByName(ROLE_ADMIN);
        inOrder.verify(addressServiceMock).findById(ADDRESS_ID);
        inOrder.verify(userRepositoryMock).save(expectedUser);

        verifyNoMoreInteractions(roleServiceMock, addressServiceMock, userRepositoryMock);
    }

    @Test
    void updateShouldThrowExceptionTest() {
        assertThrows(RuntimeException.class, () -> userService.update(null), "User can't be null");
    }

    @Test
    void deleteTest() {
        userService.delete(expectedUser.getId());

        verify(userRepositoryMock).deleteById(USER_ID);   //or
        verify(userRepositoryMock).deleteById(any(UUID.class));
        verifyNoMoreInteractions(userRepositoryMock);
    }

    @Test
    void getAllUsersTest() {
        List<User> users = List.of(expectedUser);
        when(userRepositoryMock.findAll()).thenReturn(users);

        List<UserDto> usersDtoList = userService.getAllUsers();
        assertFalse(usersDtoList.isEmpty());
        assertEquals(1, usersDtoList.size());

        verify(userRepositoryMock).findAll();
        verifyNoMoreInteractions(userRepositoryMock);
    }
}