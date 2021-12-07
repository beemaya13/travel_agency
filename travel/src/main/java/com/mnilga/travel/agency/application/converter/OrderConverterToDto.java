package com.mnilga.travel.agency.application.converter;

import com.mnilga.travel.agency.application.dto.OrderDto;
import com.mnilga.travel.agency.application.dto.RoomDto;
import com.mnilga.travel.agency.application.dto.UserDto;
import com.mnilga.travel.agency.application.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OrderConverterToDto implements Converter<Order, OrderDto> {

    private UserConverterToDto userConverterToDto;
    private RoomConverterToDto roomConverterToDto;

    @Autowired
    public void setUserConverterToDto(UserConverterToDto userConverterToDto) {
        this.userConverterToDto = userConverterToDto;
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
        orderDto.setUserDto(userDto);
        RoomDto roomDto = roomConverterToDto.convert(order.getRoom());
        orderDto.setRoomDto(roomDto);
        return orderDto;
    }
}
