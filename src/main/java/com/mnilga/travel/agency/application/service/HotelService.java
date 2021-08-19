package com.mnilga.travel.agency.application.service;

import com.mnilga.travel.agency.application.model.Hotel;

import java.util.List;
import java.util.Set;

public interface HotelService {
    boolean addHotel(Hotel hotel);
    Hotel getHotelById(Long id);
    Hotel getHotelByName(String name);
    List<Hotel> getHotelsByCountry(String country);
    List<Hotel> getAllHotels();
    void deleteHotelById(Long id);
    Set<String> getAllCountries();

}
