package com.mnilga.travel.agency.application.service.impl;

import com.mnilga.travel.agency.application.dto.OrderDto;
import com.mnilga.travel.agency.application.exceptions.ResourceNotFoundException;
import com.mnilga.travel.agency.application.model.*;
import com.mnilga.travel.agency.application.repository.OrderRepository;
import com.mnilga.travel.agency.application.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private ConversionService service;
    private HotelServiceImpl hotelService;
    private UserServiceImpl userService;
    private RoomServiceImpl roomService;

    @Autowired
    public void setService(ConversionService service) {
        this.service = service;
    }

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Autowired
    public void setHotelService(HotelServiceImpl hotelService) {
        this.hotelService = hotelService;
    }

    @Autowired
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRoomService(RoomServiceImpl roomService) {
        this.roomService = roomService;
    }

    @Override
    public OrderDto create(Order order) {
        getDetailsFromOrder(order);
        Order newOrder = orderRepository.save(order);
        return service.convert(newOrder, OrderDto.class);
    }

    private void getDetailsFromOrder(Order orderWithDetails) {
        UUID userId = orderWithDetails.getUser().getId();
        UUID roomId = orderWithDetails.getRoom().getId();
        User user = userService.findUserById(userId);
        Room room = roomService.findRoomById(roomId);
        orderWithDetails.setUser(user);
        orderWithDetails.setRoom(room);
    }

    @Override
    public OrderDto readById(UUID id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order with id = " + id + " not found!"));
        return service.convert(order, OrderDto.class);
    }

    @Override
    public OrderDto update(Order order) {
        if (order == null) {
            throw new RuntimeException("Order can't be null");
        }

        Optional<Order> optionalOrder = orderRepository.findById(order.getId());
        if (optionalOrder.isEmpty()) {
            throw new ResourceNotFoundException("Order with id = " + order.getId() + " does not exist!");
        }

        getDetailsFromOrder(order);
        Order updatedOrder = orderRepository.save(order);
        return service.convert(updatedOrder, OrderDto.class);
    }

    @Override
    public void delete(UUID id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order with id = " + id + " not found!"));
        orderRepository.delete(order);
    }

    @Override
    @Cacheable(value = "orders-cache")
    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(order -> service.convert(order, OrderDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto patch(Map<String, Object> fields, UUID id) {
        return null;
    }


//    public void testDto(){
//        Order order = new Order();
//        order.setId(UUID.randomUUID());
//        order.setArrivalDate(LocalDate.now());
//        order.setDepartureDate(LocalDate.now());
//        order.setOrderDate(LocalDate.now());
//        order.setUser(new User());
//        order.setHotel(new Hotel());
//        order.setRoom(new Room());
//        OrderDto orderDto = service.convert(order, OrderDto.class);
//        System.out.println(orderDto);
//    }
}
