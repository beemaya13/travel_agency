package com.mnilga.travel.agency.application.converter;


import com.mnilga.travel.agency.application.dto.RoleDto;
import com.mnilga.travel.agency.application.dto.UserDto;
import com.mnilga.travel.agency.application.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserConverterToDto implements Converter<User, UserDto> {

    private RoleConverterToDto roleConverterToDto;

    @Autowired
    public void setService(RoleConverterToDto roleConverterToDto) {
        this.roleConverterToDto = roleConverterToDto;
    }

    @Override
    public UserDto convert(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setSex(user.getSex().toString());
        RoleDto roleDto = roleConverterToDto.convert(user.getRole());
        userDto.setRole(roleDto);
        return userDto;
    }
}
