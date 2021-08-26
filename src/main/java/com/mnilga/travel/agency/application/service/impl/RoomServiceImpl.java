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
import java.util.Map;
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
    public RoomDto create(Room room) {
        return null;
    }

    @Override
    public RoomDto readById(UUID id) {
        return null;
    }

    @Override
    public RoomDto update(Room room) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public RoomDto patch(Map<String, Object> fields, UUID id) {
        return null;
    }

    @Override
    public List<RoomDto> getAllRooms() {
        return null;
    }
}
