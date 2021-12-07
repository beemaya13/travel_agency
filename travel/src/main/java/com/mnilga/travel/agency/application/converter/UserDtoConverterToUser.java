package com.mnilga.travel.agency.application.converter;


import com.mnilga.travel.agency.application.dto.UserDto;
import com.mnilga.travel.agency.application.model.Address;
import com.mnilga.travel.agency.application.model.Role;
import com.mnilga.travel.agency.application.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverterToUser implements Converter<UserDto, User> {

    private RoleDtoConverterToRole roleDtoConverterToRole;
    private AddressDtoConverterToAddress addressDtoConverterToAddress;

    @Autowired
    public void setRoleDtoConverterToRole(RoleDtoConverterToRole roleDtoConverterToRole) {
        this.roleDtoConverterToRole = roleDtoConverterToRole;
    }

    @Autowired
    public void setAddressDtoConverterToAddress(AddressDtoConverterToAddress addressDtoConverterToAddress) {
        this.addressDtoConverterToAddress = addressDtoConverterToAddress;
    }

    @Override
    public User convert(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setSex(User.Sex.valueOf(userDto.getSex()));
        Role role = roleDtoConverterToRole.convert(userDto.getRoleDto());
        user.setRole(role);
        Address address = addressDtoConverterToAddress.convert(userDto.getAddressDto());
        user.setAddress(address);
        return user;
    }
}
