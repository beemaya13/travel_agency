package com.mnilga.travel.agency.application.converter;

import com.mnilga.travel.agency.application.dto.OrderDto;
import com.mnilga.travel.agency.application.model.Hotel;
import com.mnilga.travel.agency.application.model.Order;
import com.mnilga.travel.agency.application.model.Room;
import com.mnilga.travel.agency.application.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OrderDtoConverterToOrder implements Converter<OrderDto, Order> {

    private UserDtoConverterToUser userDtoConverterToUser;
    private RoomDtoConverterToRoom roomDtoConverterToRoom;

    @Autowired
    public void setUserDtoConverterToUser(UserDtoConverterToUser userDtoConverterToUser) {
        this.userDtoConverterToUser = userDtoConverterToUser;
    }

    @Autowired
    public void setRoomDtoConverterToRoom(RoomDtoConverterToRoom roomDtoConverterToRoom) {
        this.roomDtoConverterToRoom = roomDtoConverterToRoom;
    }

    @Override
    public Order convert(OrderDto orderDto) {
        Order order = new Order();
        order.setId(orderDto.getOrderId());
        order.setArrivalDate(orderDto.getArrivalDate());
        order.setDepartureDate(orderDto.getDepartureDate());
        order.setOrderDate(orderDto.getOrderDate());
        User user = userDtoConverterToUser.convert(orderDto.getUserDto());
        order.setUser(user);
        Room room = roomDtoConverterToRoom.convert(orderDto.getRoomDto());
        order.setRoom(room);
        return order;
    }
}
