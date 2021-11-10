package com.mnilga.travel.agency.application.controller;

import com.mnilga.travel.agency.application.dto.OrderDto;
import com.mnilga.travel.agency.application.model.Order;
import com.mnilga.travel.agency.application.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid Order order) {
        OrderDto createdOrderDto = orderService.create(order);
        return new ResponseEntity<>(createdOrderDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> readById(@PathVariable UUID id) {
        OrderDto orderDto = orderService.readById(id);
        return new ResponseEntity<>(orderDto, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid Order order) {
        OrderDto updatedOrder = orderService.update(order);
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        orderService.delete(id);
        return new ResponseEntity<>("User is successfully deleted!", HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<?> getAllOrders() {
        List<OrderDto> orderDtoList = orderService.getAllOrders();
        return new ResponseEntity<>(orderDtoList, HttpStatus.OK);
    }
}
