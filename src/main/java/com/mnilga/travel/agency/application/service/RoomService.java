package com.mnilga.travel.agency.application.service;

import com.mnilga.travel.agency.application.dto.RoomDto;
import com.mnilga.travel.agency.application.model.Hotel;
import com.mnilga.travel.agency.application.model.Room;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface RoomService {
    boolean addRoom(Room room);         //RoomDto addRoom(Room room);
    RoomDto getRoomById(String id);     //RoomDto getRoomById(UUID id);
    RoomDto getRoomByHotelAndNumber(Hotel hotel, Integer number);   // ???RoomDto getRoomByHotelAndNumber(HotelDto hotel, String number);
    List<RoomDto> getAllRooms();
    List<RoomDto>getAvailableRooms(String country, LocalDate arrivalDate,  LocalDate departureDate);  //??(String country, String arrivalDate,  String departureDate)
    void deleteRoom(UUID id);
}
