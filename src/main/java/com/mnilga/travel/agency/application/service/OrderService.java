package com.mnilga.travel.agency.application.service;

import com.mnilga.travel.agency.application.dto.OrderDto;
import com.mnilga.travel.agency.application.model.Order;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    void addOrder(Order order);
    OrderDto getOrderById(String id);   //  or UUID id
    List<OrderDto> getOrdersByUserId(UUID userId);  // or String userId
    List<OrderDto> getOrdersByHotelId(UUID hotelId);  // or String hotelId
    void deleteOrderById(UUID id);
}
