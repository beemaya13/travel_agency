package com.mnilga.travel.agency.application.service.impl;

import com.mnilga.travel.agency.application.model.Order;
import com.mnilga.travel.agency.application.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public void addOrder(Order order) {

    }

    @Override
    public Order getOrderById(Long id) {
        return null;
    }

    @Override
    public List<Order> getOrdersByUserId(Long userId) {
        return null;
    }

    @Override
    public List<Order> getOrdersByHotelId(Long hotelId) {
        return null;
    }

    @Override
    public void deleteOrderById(Long id) {

    }
}
