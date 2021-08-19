package com.mnilga.travel.agency.application.service.impl;

import com.mnilga.travel.agency.application.model.Hotel;
import com.mnilga.travel.agency.application.model.Room;
import com.mnilga.travel.agency.application.service.RoomService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Override
    public boolean addRoom(Room room) {
        return false;
    }

    @Override
    public Room getRoomById(Long id) {
        return null;
    }

    @Override
    public Room getRoomByHotelAndNumber(Hotel hotel, Integer number) {
        return null;
    }

    @Override
    public List<Room> getAllRooms() {
        return null;
    }

    @Override
    public List<Room> getAvailableRooms(String country, LocalDate arrivalDate, LocalDate departureDate) {
        return null;
    }

    @Override
    public void deleteRoom(Long id) {

    }
}
