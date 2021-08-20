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
    public boolean addHotel(Hotel hotel) {
        return false;
    }

    @Override
    public HotelDto getHotelById(String id) {
        return null;
    }

    @Override
    public HotelDto getHotelByName(String name) {
        return null;
    }

    @Override
    public List<HotelDto> getHotelsByCountry(String country) {
        return null;
    }

    @Override
    public List<HotelDto> getAllHotels() {
        return null;
    }

    @Override
    public void deleteHotelById(UUID id) {

    }

    @Override
    public Set<String> getAllCountries() {
        return null;
    }
}
