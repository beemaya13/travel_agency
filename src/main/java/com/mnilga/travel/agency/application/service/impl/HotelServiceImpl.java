package com.mnilga.travel.agency.application.service.impl;

import com.mnilga.travel.agency.application.model.Hotel;
import com.mnilga.travel.agency.application.service.HotelService;

import java.util.List;
import java.util.Set;

public class HotelServiceImpl implements HotelService {
    @Override
    public boolean addHotel(Hotel hotel) {
        return false;
    }

    @Override
    public Hotel getHotelById(Long id) {
        return null;
    }

    @Override
    public Hotel getHotelByName(String name) {
        return null;
    }

    @Override
    public List<Hotel> getHotelsByCountry(String country) {
        return null;
    }

    @Override
    public List<Hotel> getAllHotels() {
        return null;
    }

    @Override
    public void deleteHotelById(Long id) {

    }

    @Override
    public Set<String> getAllCountries() {
        return null;
    }
}
