package com.mnilga.travel.agency.application.util;

import java.util.List;

import com.mnilga.travel.agency.application.dto.UserDto;
import com.mnilga.travel.agency.application.model.Address;
import com.mnilga.travel.agency.application.model.Order;
import com.mnilga.travel.agency.application.model.Role;
import com.mnilga.travel.agency.application.model.User;

public class TestDataFactory {

    public static final String EMAIL = "example@mail.com";
    public static final String ROLE_ADMIN = "Admin";
    public static final int ZIPCODE = 61000;
    public static final int FLAT_NUMBER = 13;
    public static final int HOUSE_NUMBER = 12;
    public static final String STREET = "Lenina";
    public static final String CITY = "Lviv";
    public static final String COUNTRY = "Ukraine";

    public static User createUser (){
        User user = new User();
        user.setEmail(EMAIL);
        user.setFirstName("");
        user.setLastName("");
        user.setSex(User.Sex.FEMALE);
        user.setRole(createRole());
        user.setAddress(createAddress());
        user.setOrders(List.of(createOrder()));
        return user;
    }

    public static UserDto createUserDto (){
        UserDto userDto = new UserDto();
        userDto.setEmail(EMAIL);
        userDto.setFirstName("");
        userDto.setLastName("");
        userDto.setSex(User.Sex.FEMALE.name());
        userDto.setRole(null);
        userDto.setAddressDto(null);
        return userDto;
    }

    public static Role createRole(){
        Role role = new Role();
        role.setName(ROLE_ADMIN);
        return role;
    }

    public static Address createAddress(){
        Address address = new Address();
        address.setCountry(COUNTRY);
        address.setCity(CITY);
        address.setStreet(STREET);
        address.setHouseNumber(HOUSE_NUMBER);
        address.setFlatNumber(FLAT_NUMBER);
        address.setZipcode(ZIPCODE);
        return address;
    }
    public static Order createOrder(){
        return new Order();
    }

}
