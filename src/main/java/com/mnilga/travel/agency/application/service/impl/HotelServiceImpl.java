package com.mnilga.travel.agency.application.service.impl;

import com.mnilga.travel.agency.application.dto.HotelDto;
import com.mnilga.travel.agency.application.exceptions.ResourceNotFoundException;
import com.mnilga.travel.agency.application.model.Hotel;
import com.mnilga.travel.agency.application.repository.HotelRepository;
import com.mnilga.travel.agency.application.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService {

    private HotelRepository hotelRepository;
    private ConversionService service;

    @Autowired
    public void setHotelRepository(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Autowired
    public void setService(ConversionService service) {
        this.service = service;
    }

    @Override
    public HotelDto create(Hotel hotel) {
        Hotel newHotel = hotelRepository.save(hotel);
        return service.convert(newHotel, HotelDto.class);
    }

    @Override
    public HotelDto readById(UUID id) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel with id = " + id + " not found!"));
        return service.convert(hotel, HotelDto.class);
    }

    @Override
    public HotelDto update(Hotel hotel) {
        if (hotel == null) {
            throw new RuntimeException("Hotel can't be null");
        }

        Optional.ofNullable(hotelRepository.findByName(hotel.getName()))
                .orElseThrow(() -> new ResourceNotFoundException("Hotel with name = " + hotel.getName() + " does not exist!"));

        Hotel updatedHotel = hotelRepository.save(hotel);
        return service.convert(updatedHotel, HotelDto.class);
    }

    @Override
    public void delete(UUID id) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel with id=" + id + " not found!"));
        hotelRepository.delete(hotel);
    }

    @Override
    public List<HotelDto> getAllHotels() {
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels.stream()
                .map(hotel -> service.convert(hotel, HotelDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public HotelDto patch(Map<String, Object> fields, UUID id) {
        return null;
    }


//    public void testDto(){
//        Hotel hotel = new Hotel();
//        hotel.setId(UUID.randomUUID());
//        hotel.setName("Rixos");
//        hotel.setCountry("Turkey");
//        hotel.setCity("Kemer");
//        hotel.setDateCreated(LocalDateTime.now());
//        HotelDto hotelDto = service.convert(hotel, HotelDto.class);
//        System.out.println(hotelDto);
//    }
}
