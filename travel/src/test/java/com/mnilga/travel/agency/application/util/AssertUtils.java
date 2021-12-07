package com.mnilga.travel.agency.application.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.BiConsumer;

import com.mnilga.travel.agency.application.dto.AddressDto;
import com.mnilga.travel.agency.application.dto.UserDto;
import com.mnilga.travel.agency.application.model.Address;
import com.mnilga.travel.agency.application.model.Order;
import com.mnilga.travel.agency.application.model.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssertUtils {

    public static void assertUser(User expected, User actual){
        assertNotNull(actual);
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

    public static void assertOrder(Order expected, Order actual) {
        assertNotNull(actual);
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
