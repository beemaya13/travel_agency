package com.mnilga.travel.agency.application.service;

import com.mnilga.travel.agency.application.dto.HotelDto;
import com.mnilga.travel.agency.application.dto.UserDto;
import com.mnilga.travel.agency.application.model.Hotel;
import com.mnilga.travel.agency.application.model.User;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public interface HotelService {
    HotelDto create(Hotel hotel);
    HotelDto readById(UUID id);
    HotelDto update(Hotel hotel);
    void delete(UUID id);
    HotelDto patch(Map<String, Object> fields, UUID id);
    List<HotelDto> getAllHotels();

}
