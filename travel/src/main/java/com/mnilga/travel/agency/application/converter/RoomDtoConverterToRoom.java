package com.mnilga.travel.agency.application.converter;

import com.mnilga.travel.agency.application.dto.RoomDto;
import com.mnilga.travel.agency.application.model.Hotel;
import com.mnilga.travel.agency.application.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoomDtoConverterToRoom implements Converter<RoomDto, Room> {

    private HotelDtoConverterToHotel hotelDtoConverterToHotel;

    @Autowired
    public void setService(HotelDtoConverterToHotel hotelDtoConverterToHotel) {
        this.hotelDtoConverterToHotel = hotelDtoConverterToHotel;
    }

    @Override
    public Room convert(RoomDto roomDto) {
        Room room = new Room();
        room.setId(roomDto.getRoomId());
        room.setRoomNumber(roomDto.getRoomNumber());
        room.setRoomType(Room.RoomType.valueOf(roomDto.getRoomType()));
        room.setPrice(roomDto.getPrice());
        Hotel hotel = hotelDtoConverterToHotel.convert(roomDto.getHotel());
        room.setHotel(hotel);
        return room;
    }
}
