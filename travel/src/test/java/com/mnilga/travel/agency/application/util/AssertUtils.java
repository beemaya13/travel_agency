package com.mnilga.travel.agency.application.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.BiConsumer;

import com.mnilga.travel.agency.application.dto.*;
import com.mnilga.travel.agency.application.model.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssertUtils {

    public static void assertUser(User expected, User actual){
        assertNotNull(actual);
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getEmail(), actual.getEmail());
        assertEquals(expected.getFirstName(), actual.getFirstName());
        assertEquals(expected.getLastName(), actual.getLastName());
        assertEquals(expected.getSex(), actual.getSex());
        assertEquals(expected.getRole(), actual.getRole());
        assertAddress(expected.getAddress(), actual.getAddress());
        assertCollections(expected.getOrders(), actual.getOrders(), AssertUtils::assertOrder);
    }

    public static void assertUserDto(UserDto expected, UserDto actual){
        assertNotNull(actual);
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getEmail(), actual.getEmail());
        assertEquals(expected.getFirstName(), actual.getFirstName());
        assertEquals(expected.getLastName(), actual.getLastName());
        assertEquals(expected.getSex(), actual.getSex());
        assertEquals(expected.getRoleDto(), actual.getRoleDto());
        assertAddressDto(expected.getAddressDto(), actual.getAddressDto());
    }

    public static void assertAddress(Address expected, Address actual){
        assertNotNull(actual);
        assertEquals(expected.getCountry(), actual.getCountry());
        assertEquals(expected.getCity(), actual.getCity());
        assertEquals(expected.getStreet(), actual.getStreet());
        assertEquals(expected.getHouseNumber(), actual.getHouseNumber());
        assertEquals(expected.getFlatNumber(), actual.getFlatNumber());
        assertEquals(expected.getZipcode(), actual.getZipcode());
    }

    public static void assertAddressDto(AddressDto expected, AddressDto actual){
        assertNotNull(actual);
        assertEquals(expected.getCountry(), actual.getCountry());
        assertEquals(expected.getCity(), actual.getCity());
        assertEquals(expected.getStreet(), actual.getStreet());
        assertEquals(expected.getHouseNumber(), actual.getHouseNumber());
        assertEquals(expected.getFlatNumber(), actual.getFlatNumber());
        assertEquals(expected.getZipcode(), actual.getZipcode());
    }

    public static void assertCountry(Country expected, Country actual){
        assertNotNull(actual);
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getCapital(), actual.getCapital());
        assertEquals(expected.getContinent(), actual.getContinent());
        assertEquals(expected.getIso(), actual.getIso());
        assertCollections(expected.getCities(), actual.getCities(), AssertUtils::assertCity);
    }

    public static void assertCountryDto(CountryDto expected, CountryDto actual){
        assertNotNull(actual);
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getCapital(), actual.getCapital());
        assertEquals(expected.getContinent(), actual.getContinent());
        assertEquals(expected.getIso(), actual.getIso());
    }

    public static void assertCity(City expected, City actual){
        assertNotNull(actual);
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getName(), actual.getName());
        assertCountry(expected.getCountry(), actual.getCountry());
        assertCollections(expected.getHotels(), actual.getHotels(), AssertUtils::assertHotel);
    }

    public static void assertCityDto(CityDto expected, CityDto actual){
        assertNotNull(actual);
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getName(), actual.getName());
        assertCountryDto(expected.getCountry(), actual.getCountry());
    }


    public static void assertHotel(Hotel expected, Hotel actual){
        assertNotNull(actual);
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getSquare(), actual.getSquare());
        assertEquals(expected.getStars(), actual.getStars());
        assertCity(expected.getCity(), actual.getCity());
        assertCollections(expected.getRooms(), actual.getRooms(), AssertUtils::assertRoom);
    }

    public static void assertHotelDto(HotelDto expected, HotelDto actual){
        assertNotNull(actual);
        assertEquals(expected.getHotelId(), actual.getHotelId());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getSquare(), actual.getSquare());
        assertEquals(expected.getStars(), actual.getStars());
        assertCityDto(expected.getCityDto(), actual.getCityDto());
    }

    public static void assertRoom(Room expected, Room actual) {
        assertNotNull(actual);
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getRoomNumber(), actual.getRoomNumber());
        assertEquals(expected.getRoomType(), actual.getRoomType());
        assertEquals(expected.getPrice(), actual.getPrice(), 0);
        assertHotel(expected.getHotel(), actual.getHotel());
        assertCollections(expected.getOrders(), actual.getOrders(), AssertUtils::assertOrder);
    }

    public static void assertRoomDto(RoomDto expected, RoomDto actual){
        assertNotNull(actual);
        assertEquals(expected.getRoomId(), actual.getRoomId());
        assertEquals(expected.getRoomNumber(), actual.getRoomNumber());
        assertEquals(expected.getRoomType(), actual.getRoomType());
        assertEquals(expected.getPrice(), actual.getPrice(), 0);
        assertHotelDto(expected.getHotelDto(), actual.getHotelDto());
    }

    public static void assertOrder(Order expected, Order actual) {
        assertNotNull(actual);
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getArrivalDate(), actual.getArrivalDate());
        assertEquals(expected.getDepartureDate(), actual.getDepartureDate());
        assertEquals(expected.getOrderDate(), actual.getOrderDate());
        assertRoom(expected.getRoom(), actual.getRoom());
        assertUser(expected.getUser(), actual.getUser());
    }

    public static void assertOrderDto(OrderDto expected, OrderDto actual){
        assertNotNull(actual);
        assertEquals(expected.getOrderId(), actual.getOrderId());
        assertEquals(expected.getOrderDate(), actual.getOrderDate());
        assertEquals(expected.getArrivalDate(), actual.getArrivalDate());
        assertEquals(expected.getDepartureDate(), actual.getDepartureDate());
        assertRoomDto(expected.getRoomDto(), actual.getRoomDto());
        assertUserDto(expected.getUserDto(), actual.getUserDto());
    }

    public static <T> void assertCollections(Collection<T> expected, Collection<T> actual, BiConsumer<T, T> assertFunction) {
        assertNotNull(actual);
        assertTrue(actual.size() != 0);
        assertEquals(expected.size(), actual.size());
        Iterator<T> eIterator = expected.iterator();
        Iterator<T> aIterator = actual.iterator();
        while (eIterator.hasNext()){
            T e = eIterator.next();
            T a = aIterator.next();
            assertFunction.accept(e, a);
        }
    }
}
