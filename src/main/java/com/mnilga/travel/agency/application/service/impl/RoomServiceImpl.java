package com.mnilga.travel.agency.application.service.impl;


import com.mnilga.travel.agency.application.dto.RoomDto;
import com.mnilga.travel.agency.application.model.Hotel;
import com.mnilga.travel.agency.application.model.Room;
import com.mnilga.travel.agency.application.service.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class RoomServiceImpl implements RoomService {

    private ConversionService service;

    @Autowired
    public void setService(ConversionService service) {
        this.service = service;
    }


    public void testDto() {
        Room room = new Room();
        room.setId(UUID.randomUUID());
        room.setRoomNumber(13);
        room.setRoomType(Room.RoomType.SINGLE);
        room.setPrice(2000.0);
        room.setHotel(new Hotel());

        RoomDto roomDto = service.convert(room, RoomDto.class);
        System.out.println(roomDto);
    }

    @Override
    public boolean addRoom(Room room) {
        return false;
    }

    @Override
    public RoomDto getRoomById(String id) {
        return null;
    }

    @Override
    public RoomDto getRoomByHotelAndNumber(Hotel hotel, Integer number) {
        return null;
    }

    @Override
    public List<RoomDto> getAllRooms() {
        return null;
    }

    @Override
    public List<RoomDto> getAvailableRooms(String country, LocalDate arrivalDate, LocalDate departureDate) {
        return null;
    }

    @Override
    public void deleteRoom(UUID id) {

    }
}
