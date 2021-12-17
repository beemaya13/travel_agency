package com.mnilga.travel.agency.application.service.impl;

import com.mnilga.travel.agency.application.converter.RoleConverterToDto;
import com.mnilga.travel.agency.application.dto.RoleDto;
import com.mnilga.travel.agency.application.dto.UserDto;
import com.mnilga.travel.agency.application.exceptions.ResourceNotFoundException;
import com.mnilga.travel.agency.application.model.Role;
import com.mnilga.travel.agency.application.model.User;
import com.mnilga.travel.agency.application.repository.RoleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.GenericConversionService;

import java.util.List;
import java.util.Optional;

import static com.mnilga.travel.agency.application.util.AssertUtils.assertRoleDto;
import static com.mnilga.travel.agency.application.util.AssertUtils.assertUserDto;
import static com.mnilga.travel.agency.application.util.TestDataFactory.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RoleServiceImplTest {

    @Mock
    private RoleRepository roleRepositoryMock;
    @InjectMocks
    private RoleServiceImpl roleService;

    private GenericConversionService genericConversionService = new GenericConversionService();
    private ConversionService conversionServiceSpy;
    private static Role expectedRole;
    private static RoleDto expectedRoleDto;

    {
        RoleConverterToDto roleConverterToDto = new RoleConverterToDto();
        genericConversionService.addConverter(roleConverterToDto);
        conversionServiceSpy = spy(genericConversionService);
    }

    @BeforeEach
    public void initProcedure() {
        expectedRole = createRole();
        expectedRoleDto = createRoleDto();
    }

    @Test
    void createTest() {
        when(roleRepositoryMock.save(expectedRole)).thenReturn(expectedRole);

        RoleDto actualRoleDto = roleService.create(expectedRole);
        assertRoleDto(expectedRoleDto, actualRoleDto);

        verify(roleRepositoryMock).save(expectedRole);
        verifyNoMoreInteractions(roleRepositoryMock);

    }

    @Test
    void createShouldThrowExceptionTest() {
        assertThrows(RuntimeException.class, () -> roleService.create(null), "Role can't be null");
    }

    @Test
    void readByIdTest() {
        when(roleRepositoryMock.findById(ROLE_ID)).thenReturn(Optional.of(expectedRole));

        RoleDto actualRoleDto = roleService.readById(ROLE_ID);
        assertRoleDto(expectedRoleDto, actualRoleDto);

        verify(roleRepositoryMock).findById(ROLE_ID);
        verifyNoMoreInteractions(roleRepositoryMock);

    }

    @Test
    void updateTest() {
        when(roleRepositoryMock.findByName(ROLE_ADMIN)).thenReturn(Optional.of(expectedRole));
        when(roleRepositoryMock.save(expectedRole)).thenReturn(expectedRole);

        RoleDto actualRoleDto = roleService.update(expectedRole);
        assertRoleDto(expectedRoleDto, actualRoleDto);

        verify(roleRepositoryMock).findByName(ROLE_ADMIN);
        verify(roleRepositoryMock).save(expectedRole);
        verifyNoMoreInteractions(roleRepositoryMock);
    }

    @Test
    void updateShouldThrowExceptionTest() {
        assertThrows(RuntimeException.class, () -> roleService.update(null), "Role can't be null");
    }

    @Test
    void updateShouldThrowExceptionNotFoundTest() {

        when(roleRepositoryMock.findByName("Incorrect value")).thenThrow(ResourceNotFoundException.class);

        Role incorrectRole = createRole();
        incorrectRole.setName("Incorrect value");
        assertThrows(ResourceNotFoundException.class,
                () -> roleService.update(incorrectRole),
                "Role with name = " + incorrectRole.getName() + " does not exist!");

        verify(roleRepositoryMock).findByName("Incorrect value");
    }

    @Test
    void deleteTest() {
        when(roleRepositoryMock.findById(ROLE_ID)).thenReturn(Optional.of(expectedRole));
        roleService.delete(expectedRole.getId());

        verify(roleRepositoryMock).findById(ROLE_ID);
        verify(roleRepositoryMock).delete(expectedRole);
        verifyNoMoreInteractions(roleRepositoryMock);
    }

    @Test
    void getAllRoles() {
        List<Role> roles = List.of(expectedRole);
        when(roleRepositoryMock.findAll()).thenReturn(roles);

        List<RoleDto> rolesDtoList = roleService.getAllRoles();
        assertFalse(rolesDtoList.isEmpty());
        assertEquals(1, rolesDtoList.size());

        verify(roleRepositoryMock).findAll();
        verifyNoMoreInteractions(roleRepositoryMock);
    }
}