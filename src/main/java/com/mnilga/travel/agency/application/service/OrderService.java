package com.mnilga.travel.agency.application.service;

import com.mnilga.travel.agency.application.model.Order;

import java.util.List;

public interface OrderService {
    void addOrder(Order order);
    Order getOrderById(Long id);
    List<Order> getOrdersByUserId(Long userId);
    List<Order> getOrdersByHotelId(Long hotelId);
    void deleteOrderById(Long id);
}
