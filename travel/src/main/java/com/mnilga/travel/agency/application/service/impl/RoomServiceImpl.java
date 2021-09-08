package com.mnilga.travel.agency.application.service.impl;


import com.mnilga.travel.agency.application.dto.RoomDto;
import com.mnilga.travel.agency.application.exceptions.ResourceNotFoundException;
import com.mnilga.travel.agency.application.model.Hotel;
import com.mnilga.travel.agency.application.model.Room;
import com.mnilga.travel.agency.application.repository.RoomRepository;
import com.mnilga.travel.agency.application.service.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService {

    private RoomRepository roomRepository;
    private ConversionService service;
    private HotelServiceImpl hotelService;

    @Autowired
    public void setService(ConversionService service) {
        this.service = service;
    }

    @Autowired
    public void setRoomRepository(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Autowired
    public void setHotelService(HotelServiceImpl hotelService) {
        this.hotelService = hotelService;
    }

    @Override
    public RoomDto create(Room room) {
        getHotelFromRoom(room);
        Room newRoom = roomRepository.save(room);
        return service.convert(newRoom, RoomDto.class);
    }

    private void getHotelFromRoom(Room roomWithHotel) {
        String hotelName = roomWithHotel.getHotel().getName();
        Hotel hotel = hotelService.findByName(hotelName);
        roomWithHotel.setHotel(hotel);
    }

    @Override
    public RoomDto readById(UUID id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room with id = " + id + " not found!"));
        return service.convert(room, RoomDto.class);
    }

    @Override
    public RoomDto update(Room room) {
        if (room == null) {
            throw new RuntimeException("Room can't be null");
        }

        Optional.ofNullable(roomRepository.findByRoomNumber(room.getRoomNumber()))
                .orElseThrow(() -> new ResourceNotFoundException("Room with roomNumber = " + room.getRoomNumber() + " does not exist!"));

        getHotelFromRoom(room);
        Room updatedRoom = roomRepository.save(room);
        return service.convert(updatedRoom, RoomDto.class);
    }

    @Override
    public void delete(UUID id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room with id = " + id + " not found!"));
        roomRepository.delete(room);
    }

    @Override
    @Cacheable(value = "rooms-cache")
    public List<RoomDto> getAllRooms() {
        List<Room> rooms = roomRepository.findAll();
        return rooms.stream()
                .map(room -> service.convert(room, RoomDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Room findRoomById(UUID id) {
        return roomRepository.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException("Room with id =" + id + " does not exist!");
        });
    }


//    public void testDto() {
//        Room room = new Room();
//        room.setId(UUID.randomUUID());
//        room.setRoomNumber(13);
//        room.setRoomType(Room.RoomType.SINGLE);
//        room.setPrice(2000.0);
//        room.setHotel(new Hotel());
//        RoomDto roomDto = service.convert(room, RoomDto.class);
//        System.out.println(roomDto);
//    }
}
