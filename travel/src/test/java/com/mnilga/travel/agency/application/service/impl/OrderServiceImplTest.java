package com.mnilga.travel.agency.application.service.impl;

import com.mnilga.travel.agency.application.converter.*;
import com.mnilga.travel.agency.application.dto.OrderDto;
import com.mnilga.travel.agency.application.model.Order;
import com.mnilga.travel.agency.application.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.GenericConversionService;

import static com.mnilga.travel.agency.application.util.TestDataFactory.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepositoryMock;
    @Mock
    private UserServiceImpl userService;
    @Mock
    private RoomServiceImpl roomService;

    @InjectMocks
    private OrderServiceImpl orderService;

    private GenericConversionService genericConversionService = new GenericConversionService();
    private ConversionService conversionServiceSpy;
    private static Order expectedOrder;
    private static OrderDto expectedOrderDto;

    {
        OrderConverterToDto orderConverterToDto = new OrderConverterToDto();
        orderConverterToDto.setRoomConverterToDto(new RoomConverterToDto());
        orderConverterToDto.setUserConverterToDto(new UserConverterToDto());
        genericConversionService.addConverter(orderConverterToDto);
        conversionServiceSpy = spy(genericConversionService);
        expectedOrder = createOrder();
        expectedOrderDto = createOrderDto();
    }

    @Test
    void create() {
    }

    @Test
    void readById() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void getAllOrders() {
    }
}