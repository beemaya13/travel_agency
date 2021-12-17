package com.mnilga.travel.agency.application.util;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.mnilga.travel.agency.application.dto.*;
import com.mnilga.travel.agency.application.model.*;

public class TestDataFactory {

    public static final UUID USER_ID = UUID.fromString("6478eef6-6358-40cb-a0b7-3e6fe372cc1a");
    public static final UUID ADDRESS_ID = UUID.fromString("7578eef6-6358-40cb-a0b7-3e6fe372cc1a");
    public static final UUID ROLE_ID = UUID.fromString("9978eef6-6358-40cb-a0b7-3e6fe372cc1a");
    public static final UUID ORDER_ID = UUID.fromString("8878eef6-6358-40cb-a0b7-3e6fe772cc1a");
    public static final UUID ROOM_ID = UUID.fromString("7778eef6-6358-40cb-a0b7-3e6fe772cc1a");
    public static final UUID HOTEL_ID = UUID.fromString("6678eef6-6358-40cb-a0b7-3e6fe772cc1a");
    public static final UUID CITY_ID = UUID.fromString("5578eef6-6358-40cb-a0b7-3e6fe772cc1a");
    public static final UUID COUNTRY_ID = UUID.fromString("4478eef6-6358-40cb-a0b7-3e6fe772cc1a");
    public static final String EMAIL = "example@mail.com";
    public static final String FIRST_NAME = "Ira";
    public static final String LAST_NAME = "Ivanova";
    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_USER = "USER";
    public static final int ZIPCODE = 61000;
    public static final int FLAT_NUMBER = 13;
    public static final int HOUSE_NUMBER = 12;
    public static final String STREET = "Lenina";
    public static final String CITY_NAME = "Lviv";
    public static final String COUNTRY_NAME = "Ukraine";
    public static final LocalDate ARRIVAL_DATE = LocalDate.of(2022, 1, 1);
    public static final LocalDate DEPARTURE_DATE = LocalDate.of(2022, 1, 14);
    public static final LocalDate ORDER_DATE = LocalDate.of(2021, 12, 7);
    private static final Integer ROOM_NUMBER = 13;
    private static final Room.RoomType ROOM_TYPE = Room.RoomType.valueOf("DOUBLE");
    private static final Double PRICE = 2000.0;
    private static final String HOTEL_NAME = "Rixos";
    private static final Integer STARS = 5;
    private static final Integer SQUARE = 100000;
    private static final String ISO = "UK";
    private static final String CONTINENT = "EUROPE";

    public static User createUser (){
        User user = new User();
        user.setId(USER_ID);
        user.setEmail(EMAIL);
        user.setFirstName(FIRST_NAME);
        user.setLastName(LAST_NAME);
        user.setSex(User.Sex.FEMALE);
        user.setRole(createRole());
        user.setAddress(createAddress());
        //user.setOrders(List.of(createOrder()));
        return user;
    }

    public static UserDto createUserDto (){
        UserDto userDto = new UserDto();
        userDto.setId(USER_ID);
        userDto.setEmail(EMAIL);
        userDto.setFirstName(FIRST_NAME);
        userDto.setLastName(LAST_NAME);
        userDto.setSex(User.Sex.FEMALE.name());
        userDto.setRoleDto(createRoleDto());
        userDto.setAddressDto(createAddressDto());
        return userDto;
    }

    public static Map<String, Object> createUserPatchFields() {
        Map<String, Object> patchFields = new HashMap<>();
        patchFields.put("first_name", "patched_first_name");
        patchFields.put("email", "patched_email");
        return patchFields;
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
        address.setCountry(COUNTRY_NAME);
        address.setCity(CITY_NAME);
        address.setStreet(STREET);
        address.setHouseNumber(HOUSE_NUMBER);
        address.setFlatNumber(FLAT_NUMBER);
        address.setZipcode(ZIPCODE);
        return address;
    }

    public static AddressDto createAddressDto(){
        AddressDto addressDto = new AddressDto();
        addressDto.setId(ADDRESS_ID);
        addressDto.setCountry(COUNTRY_NAME);
        addressDto.setCity(CITY_NAME);
        addressDto.setStreet(STREET);
        addressDto.setHouseNumber(HOUSE_NUMBER);
        addressDto.setFlatNumber(FLAT_NUMBER);
        addressDto.setZipcode(ZIPCODE);
        return addressDto;
    }

    public static Country createCountry(){
        Country country = new Country();
        country.setId(COUNTRY_ID);
        country.setName(COUNTRY_NAME);
        country.setIso(ISO);
        country.setCapital(CITY_NAME);
        country.setContinent(CONTINENT);
        //country.setCities(List.of(createCity()));
        return country;
    }

    public static CountryDto createCountryDto(){
        CountryDto countryDto = new CountryDto();
        countryDto.setId(COUNTRY_ID);
        countryDto.setName(COUNTRY_NAME);
        countryDto.setIso(ISO);
        countryDto.setCapital(CITY_NAME);
        countryDto.setContinent(CONTINENT);
        return countryDto;
    }

    public static City createCity(){
        City city = new City();
        city.setId(CITY_ID);
        city.setName(CITY_NAME);
        city.setCountry(createCountry());
        //city.setHotels(List.of(createHotel()));
        return city;
    }

    public static CityDto createCityDto(){
        CityDto cityDto = new CityDto();
        cityDto.setId(CITY_ID);
        cityDto.setName(CITY_NAME);
        cityDto.setCountry(createCountryDto());
        return cityDto;
    }

    public static Hotel createHotel(){
        Hotel hotel = new Hotel();
        hotel.setId(HOTEL_ID);
        hotel.setName(HOTEL_NAME);
        hotel.setStars(STARS);
        hotel.setStars(SQUARE);
        hotel.setCity(createCity());
        //hotel.setRooms(List.of(createRoom()));
        return hotel;
    }

    public static HotelDto createHotelDto(){
        HotelDto hotelDto = new HotelDto();
        hotelDto.setHotelId(HOTEL_ID);
        hotelDto.setName(HOTEL_NAME);
        hotelDto.setStars(STARS);
        hotelDto.setStars(SQUARE);
        hotelDto.setCityDto(createCityDto());
        return hotelDto;
    }

    public static Room createRoom(){
        Room room = new Room();
        room.setId(ROOM_ID);
        room.setRoomNumber(ROOM_NUMBER);
        room.setRoomType(ROOM_TYPE);
        room.setPrice(PRICE);
        room.setHotel(createHotel());
        //room.setOrders(List.of(createOrder()));
        return room;
    }

    public static RoomDto createRoomDto(){
        RoomDto roomDto = new RoomDto();
        roomDto.setRoomId(ROOM_ID);
        roomDto.setRoomNumber(ROOM_NUMBER);
        roomDto.setRoomType(ROOM_TYPE.toString());
        roomDto.setPrice(PRICE);
        roomDto.setHotelDto(createHotelDto());
        return roomDto;
    }

    public static Order createOrder(){
        Order order = new Order();
        order.setId(ORDER_ID);
        order.setArrivalDate(ARRIVAL_DATE);
        order.setDepartureDate(DEPARTURE_DATE);
        order.setOrderDate(ORDER_DATE);
        order.setUser(createUser());
        order.setRoom(createRoom());
        return order;
    }

    public static OrderDto createOrderDto(){
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderId(ORDER_ID);
        orderDto.setArrivalDate(ARRIVAL_DATE);
        orderDto.setDepartureDate(DEPARTURE_DATE);
        orderDto.setOrderDate(ORDER_DATE);
        orderDto.setUserDto(createUserDto());
        orderDto.setRoomDto(createRoomDto());
        return orderDto;
    }
}
