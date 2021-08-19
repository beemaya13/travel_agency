package com.mnilga.travel.agency.application.converter;

import com.mnilga.travel.agency.application.dto.RoleDto;
import com.mnilga.travel.agency.application.model.Role;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RoleDtoConverterToRole implements Converter<RoleDto, Role> {

    @Override
    public Role convert(RoleDto roleDto) {
        Role role = new Role();
        role.setId(UUID.fromString(roleDto.getRoleId()));
        role.setName(roleDto.getName());
        return role;
    }
}
