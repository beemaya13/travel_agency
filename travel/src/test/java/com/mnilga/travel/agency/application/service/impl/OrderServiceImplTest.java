package com.mnilga.travel.agency.application.service.impl;

import com.mnilga.travel.agency.application.converter.*;
import com.mnilga.travel.agency.application.dto.OrderDto;
import com.mnilga.travel.agency.application.model.Order;
import com.mnilga.travel.agency.application.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.GenericConversionService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.mnilga.travel.agency.application.util.AssertUtils.assertOrderDto;
import static com.mnilga.travel.agency.application.util.TestDataFactory.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepositoryMock;
    @Mock
    private UserServiceImpl userServiceMock;
    @Mock
    private RoomServiceImpl roomServiceMock;

    @InjectMocks
    private OrderServiceImpl orderService;

    private GenericConversionService genericConversionService = new GenericConversionService();
    private ConversionService conversionServiceSpy;
    private static Order expectedOrder;
    private static OrderDto expectedOrderDto;

    {
        OrderConverterToDto orderConverterToDto = new OrderConverterToDto();
        CountryConverterToDto countryConverterToDto = new CountryConverterToDto();

        CityConverterToDto cityConverterToDto = new CityConverterToDto();
        cityConverterToDto.setCountryConverterToDto(countryConverterToDto);

        HotelConverterToDto hotelConverterToDto = new HotelConverterToDto();
        hotelConverterToDto.setCityConverterToDto(cityConverterToDto);

        RoomConverterToDto roomConverterToDto = new RoomConverterToDto();
        roomConverterToDto.setHotelConverterToDto(hotelConverterToDto);

        orderConverterToDto.setRoomConverterToDto(roomConverterToDto);

        UserConverterToDto userConverterToDto = new UserConverterToDto();
        userConverterToDto.setRoleConverterToDto(new RoleConverterToDto());
        userConverterToDto.setAddressConverterToDto(new AddressConverterToDto());

        orderConverterToDto.setUserConverterToDto(userConverterToDto);

        genericConversionService.addConverter(orderConverterToDto);
        conversionServiceSpy = spy(genericConversionService);
        expectedOrder = createOrder();
        expectedOrderDto = createOrderDto();
    }

    @Test
    void create() {
        when(userServiceMock.findUserById(USER_ID)).thenReturn(createUser());
        when(roomServiceMock.findRoomById(ROOM_ID)).thenReturn(createRoom());
        when(orderRepositoryMock.save(expectedOrder)).thenReturn(expectedOrder);

        OrderDto actualOrderDto = orderService.create(expectedOrder);
        assertOrderDto(expectedOrderDto, actualOrderDto);

        verify(userServiceMock).findUserById(USER_ID);
        verify(roomServiceMock).findRoomById(ROOM_ID);
        verify(orderRepositoryMock).save(expectedOrder);
        verifyNoMoreInteractions(userServiceMock, roomServiceMock, orderRepositoryMock);

    }

    @Test
    void createShouldThrowExceptionTest() {
        assertThrows(RuntimeException.class, () -> orderService.create(null), "Order can't be null");
    }

    @Test
    void readById() {
        when(orderRepositoryMock.findById(ORDER_ID)).thenReturn(Optional.of(expectedOrder));

        OrderDto actualOrderDto = orderService.readById(ORDER_ID);
        assertOrderDto(expectedOrderDto, actualOrderDto);

        verify(orderRepositoryMock).findById(ORDER_ID);
        verifyNoMoreInteractions(orderRepositoryMock);

    }

    @Test
    void update() {
        InOrder inOrder = inOrder(orderRepositoryMock, userServiceMock, roomServiceMock, orderRepositoryMock);

        when(orderRepositoryMock.findById(ORDER_ID)).thenReturn(Optional.ofNullable(expectedOrder));
        when(userServiceMock.findUserById(USER_ID)).thenReturn(createUser());
        when(roomServiceMock.findRoomById(ROOM_ID)).thenReturn(createRoom());
        when(orderRepositoryMock.save(expectedOrder)).thenReturn(expectedOrder);

        OrderDto actualOrderDto = orderService.update(expectedOrder);
        assertOrderDto(expectedOrderDto, actualOrderDto);

        inOrder.verify(orderRepositoryMock).findById(ORDER_ID);
        inOrder.verify(userServiceMock).findUserById(USER_ID);
        inOrder.verify(roomServiceMock).findRoomById(ROOM_ID);
        inOrder.verify(orderRepositoryMock).save(expectedOrder);
        verifyNoMoreInteractions(userServiceMock, roomServiceMock, orderRepositoryMock);
    }

    @Test
    void delete() {
        orderService.delete(expectedOrder.getId());

        verify(orderRepositoryMock).deleteById(any(UUID.class));
        verify(orderRepositoryMock).deleteById(ORDER_ID);
        verifyNoMoreInteractions(orderRepositoryMock);
    }

    @Test
    void getAllOrders() {
        List<Order> orders = List.of(expectedOrder);
        when(orderRepositoryMock.findAll()).thenReturn(orders);

        List<OrderDto> ordersDtoList = orderService.getAllOrders();
        assertFalse(ordersDtoList.isEmpty());
        assertEquals(1, ordersDtoList.size());

        verify(orderRepositoryMock).findAll();
        verifyNoMoreInteractions(orderRepositoryMock);
    }
}