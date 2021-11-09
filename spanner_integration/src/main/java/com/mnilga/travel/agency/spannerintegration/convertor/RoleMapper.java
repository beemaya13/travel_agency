package com.mnilga.travel.agency.spannerintegration.convertor;

import com.mnilga.travel.agency.spannerintegration.dto.RoleDto;
import com.mnilga.travel.agency.spannerintegration.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    @Mapping(target = "roleId", expression = "java(role.getId())")
    RoleDto roleToRoleDto(Role role);

    Role roleDtoToRole(RoleDto roleDto);
}
