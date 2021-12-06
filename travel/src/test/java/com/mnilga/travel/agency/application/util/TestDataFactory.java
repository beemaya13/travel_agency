package com.mnilga.travel.agency.application.util;

import java.util.List;
import java.util.UUID;

import com.mnilga.travel.agency.application.dto.AddressDto;
import com.mnilga.travel.agency.application.dto.RoleDto;
import com.mnilga.travel.agency.application.dto.UserDto;
import com.mnilga.travel.agency.application.model.*;

public class TestDataFactory {

    public static final UUID USER_ID = UUID.fromString("6478eef6-6358-40cb-a0b7-3e6fe372cc1a");
    public static final UUID ADDRESS_ID = UUID.fromString("7578eef6-6358-40cb-a0b7-3e6fe372cc1a");
    public static final UUID ROLE_ID = UUID.fromString("9978eef6-6358-40cb-a0b7-3e6fe372cc1a");
    public static final String EMAIL = "example@mail.com";
    public static final String FIRST_NAME = "Ira";
    public static final String LAST_NAME = "Ivanova";
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
        user.setFirstName(FIRST_NAME);
        user.setLastName(LAST_NAME);
        user.setSex(User.Sex.FEMALE);
        user.setRole(createRole());
        user.setAddress(createAddress());
        user.setOrders(List.of(createOrder()));
        return user;
    }

    public static UserDto createUserDto (){
        UserDto userDto = new UserDto();
        userDto.setEmail(EMAIL);
        userDto.setFirstName(FIRST_NAME);
        userDto.setLastName(LAST_NAME);
        userDto.setSex(User.Sex.FEMALE.name());
        userDto.setRole(createRoleDto());
        userDto.setAddressDto(createAddressDto());
        return userDto;
    }

    public static Role createRole(){
        Role role = new Role();
        role.setId(ROLE_ID);
        role.setName(ROLE_ADMIN);
        return role;
    }

    public static RoleDto createRoleDto (){
        RoleDto roleDto = new RoleDto();
        roleDto.setRoleId(ROLE_ID);
        roleDto.setName(ROLE_ADMIN);
        return roleDto;
    }

    public static Address createAddress(){
        Address address = new Address();
        address.setId(ADDRESS_ID);
        address.setCountry(COUNTRY);
        address.setCity(CITY);
        address.setStreet(STREET);
        address.setHouseNumber(HOUSE_NUMBER);
        address.setFlatNumber(FLAT_NUMBER);
        address.setZipcode(ZIPCODE);
        return address;
    }

    public static AddressDto createAddressDto(){
        AddressDto addressDto = new AddressDto();
        addressDto.setId(ADDRESS_ID);
        addressDto.setCountry(COUNTRY);
        addressDto.setCity(CITY);
        addressDto.setStreet(STREET);
        addressDto.setHouseNumber(HOUSE_NUMBER);
        addressDto.setFlatNumber(FLAT_NUMBER);
        addressDto.setZipcode(ZIPCODE);
        return addressDto;
    }

    public static Country createCountry(){
        Country country = new Country();
        return country;
    }

    public static City createCity(){
        City city = new City();
        return city;
    }

    public static Hotel createHotel(){
        Hotel hotel = new Hotel();
        return hotel;
    }

    public static Room createRoom(){
        Room room = new Room();
        return room;
    }

    public static Order createOrder(){
        Order order = new Order();
        return order;
    }

}
