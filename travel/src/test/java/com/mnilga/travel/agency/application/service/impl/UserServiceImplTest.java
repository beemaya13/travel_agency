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
    private UserRepository userRepositoryMock;
    @Mock
    private RoleServiceImpl roleServiceMock;
    @Mock
    private AddressServiceImpl addressServiceMock;

    private GenericConversionService genericConversionService = new GenericConversionService();
    private ConversionService conversionService;

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

        when(roleServiceMock.findByName(ROLE_ADMIN)).thenReturn(createRole());
        when(addressServiceMock.findById(ADDRESS_ID)).thenReturn(createAddress());
        when(userRepositoryMock.save(user)).thenReturn(user);

        UserDto actual = userService.create(user);
        assertUserDto(expected, actual);

        verify(roleServiceMock).findByName(ROLE_ADMIN);
        verify(addressServiceMock).findById(ADDRESS_ID);
        verify(userRepositoryMock).save(user);

        verifyNoMoreInteractions(roleServiceMock, addressServiceMock, userRepositoryMock);
    }


    @Test
    void createShouldThrowExceptionTest() {
        assertThrows(RuntimeException.class, () -> userService.create(null), "User can't be null");
    }

    @Test
    void readByIdTest() {
        User user = createUser();
        user.setId(USER_ID);

        UserDto expected = createUserDto();
        expected.setId(USER_ID);

        when(userRepositoryMock.findById(USER_ID)).thenReturn(Optional.of(user));

        UserDto actual = userService.readById(USER_ID);
        assertUserDto(expected, actual);

        verify(userRepositoryMock).findById(USER_ID);
    }

    @Test
    void updateTest(){
        User expectedUser = createUser();
        UserDto expected = createUserDto();

        //sequence of calling methods
        InOrder inOrder = inOrder(userRepositoryMock, roleServiceMock, addressServiceMock, userRepositoryMock);

        when(userRepositoryMock.findByEmail(EMAIL)).thenReturn(expectedUser);
        when(roleServiceMock.findByName(ROLE_ADMIN)).thenReturn(createRole());
        when(addressServiceMock.findById(ADDRESS_ID)).thenReturn(createAddress());
        when(userRepositoryMock.save(expectedUser)).thenReturn(expectedUser);

        UserDto actual = userService.update(expectedUser);
        assertUserDto(expected, actual);

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
    void deleteTest(){
        User expectedUser = createUser();
        expectedUser.setId(USER_ID);

        userService.delete(expectedUser.getId());

        verify(userRepositoryMock).deleteById(USER_ID);
        verify(userRepositoryMock).deleteById(any(UUID.class));
    }
}