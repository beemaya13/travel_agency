package com.mnilga.travel.agency.application.service;

import com.mnilga.travel.agency.application.dto.HotelDto;
import com.mnilga.travel.agency.application.model.Hotel;

import java.util.*;

public interface HotelService {
    HotelDto create(Hotel hotel);
    HotelDto readById(UUID id);
    HotelDto update(Hotel hotel);
    void delete(UUID id);
    List<HotelDto> getAllHotels();
    Hotel findByCity(String name);
    Hotel findByName(String name);
    Hotel findHotelById(UUID id);

}
