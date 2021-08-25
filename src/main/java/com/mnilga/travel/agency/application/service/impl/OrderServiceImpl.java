package com.mnilga.travel.agency.application.service.impl;

import com.mnilga.travel.agency.application.dto.OrderDto;
import com.mnilga.travel.agency.application.dto.UserDto;
import com.mnilga.travel.agency.application.model.*;
import com.mnilga.travel.agency.application.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private ConversionService service;

    @Autowired
    public void setService(ConversionService service) {
        this.service = service;
    }

    public void testDto(){
        Order order = new Order();
        order.setId(UUID.randomUUID());
        order.setArrivalDate(LocalDate.now());
        order.setDepartureDate(LocalDate.now());
        order.setOrderDate(LocalDate.now());
        order.setUser(new User());
        order.setHotel(new Hotel());
        order.setRoom(new Room());

        OrderDto orderDto = service.convert(order, OrderDto.class);
        System.out.println(orderDto);
    }

    @Override
    public void addOrder(Order order) {

    }

    @Override
    public OrderDto getOrderById(String id) {
        return null;
    }

    @Override
    public List<OrderDto> getOrdersByUserId(UUID userId) {
        return null;
    }

    @Override
    public List<OrderDto> getOrdersByHotelId(UUID hotelId) {
        return null;
    }

    @Override
    public void deleteOrderById(UUID id) {

    }
}
