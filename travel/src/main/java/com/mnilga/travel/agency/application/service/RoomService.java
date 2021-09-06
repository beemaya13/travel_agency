package com.mnilga.travel.agency.application.service;

import com.mnilga.travel.agency.application.dto.RoomDto;
import com.mnilga.travel.agency.application.model.Room;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface RoomService {
    RoomDto create(Room room);
    RoomDto readById(UUID id);
    RoomDto update(Room room);
    void delete(UUID id);
    RoomDto patch(Map<String, Object> fields, UUID id);
    List<RoomDto> getAllRooms();
    Room findRoomById(UUID id);

    //List<RoomDto>getAvailableRooms(String country, LocalDate arrivalDate,  LocalDate departureDate);
    //RoomDto getRoomByHotelAndNumber(HotelDto hotel, String number);
}
