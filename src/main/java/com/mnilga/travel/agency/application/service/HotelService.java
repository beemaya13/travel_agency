package com.mnilga.travel.agency.application.service;

import com.mnilga.travel.agency.application.dto.HotelDto;
import com.mnilga.travel.agency.application.model.Hotel;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface HotelService {

    boolean addHotel(Hotel hotel);          //HotelDto addHotel(Hotel hotel);
    HotelDto getHotelById(String id);       //HotelDto getHotelById(UUID id);
    HotelDto getHotelByName(String name);
    List<HotelDto> getHotelsByCountry(String country);
    List<HotelDto> getAllHotels();
    void deleteHotelById(UUID id);
    Set<String> getAllCountries();

}
