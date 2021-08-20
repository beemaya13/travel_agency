package com.mnilga.travel.agency.application.converter;

import com.mnilga.travel.agency.application.dto.HotelDto;
import com.mnilga.travel.agency.application.dto.RoleDto;
import com.mnilga.travel.agency.application.dto.RoomDto;
import com.mnilga.travel.agency.application.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoomConverterToDto implements Converter<Room, RoomDto> {

    private HotelConverterToDto hotelConverterToDto;

    @Autowired
    public void setService(HotelConverterToDto hotelConverterToDto) {
        this.hotelConverterToDto = hotelConverterToDto;
    }

    @Override
    public RoomDto convert(Room room) {
        RoomDto roomDto = new RoomDto();
        roomDto.setRoomId(room.getId());
        roomDto.setRoomNumber(room.getRoomNumber());
        roomDto.setRoomType(room.getRoomType().toString());
        roomDto.setPrice(room.getPrice());
        HotelDto hotelDto = hotelConverterToDto.convert(room.getHotel());
        roomDto.setHotel(hotelDto);
        return roomDto;
    }
}

