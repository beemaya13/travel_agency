package com.mnilga.travel.agency.application.converter;


import com.mnilga.travel.agency.application.dto.AddressDto;
import com.mnilga.travel.agency.application.dto.RoleDto;
import com.mnilga.travel.agency.application.dto.UserDto;
import com.mnilga.travel.agency.application.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserConverterToDto implements Converter<User, UserDto> {

    private RoleConverterToDto roleConverterToDto;
    private AddressConverterToDto addressConverterToDto;

    @Autowired
    public void setAddressConverterToDto(AddressConverterToDto addressConverterToDto) {
        this.addressConverterToDto = addressConverterToDto;
    }

    @Autowired
    public void setRoleConverterToDto(RoleConverterToDto roleConverterToDto) {
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
        AddressDto addressDto = addressConverterToDto.convert(user.getAddress());
        userDto.setAddressDto(addressDto);
        return userDto;
    }
}
