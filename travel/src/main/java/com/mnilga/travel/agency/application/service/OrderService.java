package com.mnilga.travel.agency.application.service;

import com.mnilga.travel.agency.application.dto.OrderDto;
import com.mnilga.travel.agency.application.model.Order;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface OrderService {
    OrderDto create(Order order);
    OrderDto readById(UUID id);
    OrderDto update(Order order);
    void delete(UUID id);
    OrderDto patch(Map<String, Object> fields, UUID id);
    List<OrderDto> getAllOrders();
}
