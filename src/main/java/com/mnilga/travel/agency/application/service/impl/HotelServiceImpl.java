package com.mnilga.travel.agency.application.service.impl;

import com.mnilga.travel.agency.application.dto.HotelDto;
import com.mnilga.travel.agency.application.dto.RoleDto;
import com.mnilga.travel.agency.application.model.Hotel;
import com.mnilga.travel.agency.application.model.Role;
import com.mnilga.travel.agency.application.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    private ConversionService service;

    @Autowired
    public void setService(ConversionService service) {
        this.service = service;
    }

    public void testDto(){
        Hotel hotel = new Hotel();
        hotel.setId(UUID.randomUUID());
        hotel.setName("Rixos");
        hotel.setCountry("Turkey");
        hotel.setCity("Kemer");
        hotel.setDateCreated(LocalDateTime.now());

        HotelDto hotelDto = service.convert(hotel, HotelDto.class);
        System.out.println(hotelDto);
    }


    @Override
    public HotelDto create(Hotel hotel) {
        return null;
    }

    @Override
    public HotelDto readById(UUID id) {
        return null;
    }

    @Override
    public HotelDto update(Hotel hotel) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public HotelDto patch(Map<String, Object> fields, UUID id) {
        return null;
    }

    @Override
    public List<HotelDto> getAllUsers() {
        return null;
    }
}
