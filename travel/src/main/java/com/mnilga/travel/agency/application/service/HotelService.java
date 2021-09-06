package com.mnilga.travel.agency.application.service;

import com.mnilga.travel.agency.application.dto.HotelDto;
import com.mnilga.travel.agency.application.model.Hotel;

import java.util.*;

public interface HotelService {
    HotelDto create(Hotel hotel);
    HotelDto readById(UUID id);
    HotelDto update(Hotel hotel);
    void delete(UUID id);
    HotelDto patch(Map<String, Object> fields, UUID id);
    List<HotelDto> getAllHotels();
    Optional<Hotel> findByCountry(String name);
    Hotel findByName(String name);
    Hotel findHotelById(UUID id);

}
