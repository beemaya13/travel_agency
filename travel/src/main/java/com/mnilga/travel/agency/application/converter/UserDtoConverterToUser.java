package com.mnilga.travel.agency.application.converter;


import com.mnilga.travel.agency.application.dto.UserDto;
import com.mnilga.travel.agency.application.model.Role;
import com.mnilga.travel.agency.application.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverterToUser implements Converter<UserDto, User> {

    private RoleDtoConverterToRole roleDtoConverterToRole;

    @Autowired
    public void setService(RoleDtoConverterToRole roleDtoConverterToRole) {
        this.roleDtoConverterToRole = roleDtoConverterToRole;
    }

    @Override
    public User convert(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setSex(User.Sex.valueOf(userDto.getSex()));
        Role role = roleDtoConverterToRole.convert(userDto.getRole());
        user.setRole(role);
        return user;
    }
}
