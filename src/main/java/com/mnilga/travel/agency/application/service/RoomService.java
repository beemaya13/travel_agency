package com.mnilga.travel.agency.application.service;

import com.mnilga.travel.agency.application.model.Hotel;
import com.mnilga.travel.agency.application.model.Room;

import java.time.LocalDate;
import java.util.List;

public interface RoomService {
    boolean addRoom(Room room);
    Room getRoomById(Long id);
    Room getRoomByHotelAndNumber(Hotel hotel, Integer number);
    List<Room> getAllRooms();
    List<Room>getAvailableRooms(String country, LocalDate arrivalDate,  LocalDate departureDate);
    void deleteRoom(Long id);
}
