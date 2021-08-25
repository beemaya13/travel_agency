package com.mnilga.travel.agency.application.converter;


import com.mnilga.travel.agency.application.dto.HotelDto;
import com.mnilga.travel.agency.application.dto.OrderDto;
import com.mnilga.travel.agency.application.dto.RoomDto;
import com.mnilga.travel.agency.application.dto.UserDto;
import com.mnilga.travel.agency.application.model.Order;
import com.mnilga.travel.agency.application.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
public class OrderConverterToDto implements Converter<Order, OrderDto> {

    private UserConverterToDto userConverterToDto;
    private HotelConverterToDto hotelConverterToDto;
    private RoomConverterToDto roomConverterToDto;

    @Autowired
    public void setUserConverterToDto(UserConverterToDto userConverterToDto) {
        this.userConverterToDto = userConverterToDto;
    }

    @Autowired
    public void setHotelConverterToDto(HotelConverterToDto hotelConverterToDto) {
        this.hotelConverterToDto = hotelConverterToDto;
    }

    @Autowired
    public void setRoomConverterToDto(RoomConverterToDto roomConverterToDto) {
        this.roomConverterToDto = roomConverterToDto;
    }

    @Override
    public OrderDto convert(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderId(order.getId());
        orderDto.setArrivalDate(order.getArrivalDate());
        orderDto.setDepartureDate(order.getDepartureDate());
        orderDto.setOrderDate(order.getOrderDate());
        UserDto userDto = userConverterToDto.convert(order.getUser());
        orderDto.setUser(userDto);
        HotelDto hotelDto = hotelConverterToDto.convert(order.getHotel());
        orderDto.setHotel(hotelDto);
        RoomDto roomDto = roomConverterToDto.convert(order.getRoom());
        orderDto.setRoom(roomDto);
        return orderDto;
    }
}
