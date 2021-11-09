package com.mnilga.travel.agency.application.config;

import com.mnilga.travel.agency.application.converter.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@ComponentScan
@Configuration
public class Config implements WebMvcConfigurer {

    private UserConverterToDto userConverterToDto;
    private UserDtoConverterToUser userDtoConverterToUser;
    private RoleConverterToDto roleConverterToDto;
    private RoleDtoConverterToRole roleDtoConverterToRole;
    private HotelConverterToDto hotelConverterToDto;
    private HotelDtoConverterToHotel hotelDtoConverterToHotel;
    private RoomConverterToDto roomConverterToDto;
    private RoomDtoConverterToRoom roomDtoConverterToRoom;
    private OrderConverterToDto orderConverterToDto;
    private OrderDtoConverterToOrder orderDtoConverterToOrder;

    @Autowired
    public void setRoleConverterToDto(RoleConverterToDto roleConverterToDto) {
        this.roleConverterToDto = roleConverterToDto;
    }

    @Autowired
    public void setRoleDtoConverterToRole(RoleDtoConverterToRole roleDtoConverterToRole) {
        this.roleDtoConverterToRole = roleDtoConverterToRole;
    }

    @Autowired
    public void setUserConverterToDto(UserConverterToDto userConverterToDto) {
        this.userConverterToDto = userConverterToDto;
    }

    @Autowired
    public void setUserDtoConverterToUser(UserDtoConverterToUser userDtoConverterToUser) {
        this.userDtoConverterToUser = userDtoConverterToUser;
    }

    @Autowired
    public void setHotelConverterToDto(HotelConverterToDto hotelConverterToDto) {
        this.hotelConverterToDto = hotelConverterToDto;
    }

    @Autowired
    public void setHotelDtoConverterToHotel(HotelDtoConverterToHotel hotelDtoConverterToHotel) {
        this.hotelDtoConverterToHotel = hotelDtoConverterToHotel;
    }

    @Autowired
    public void setRoomConverterToDto(RoomConverterToDto roomConverterToDto) {
        this.roomConverterToDto = roomConverterToDto;
    }

    @Autowired
    public void setRoomDtoConverterToRoom(RoomDtoConverterToRoom roomDtoConverterToRoom) {
        this.roomDtoConverterToRoom = roomDtoConverterToRoom;
    }

    @Autowired
    public void setOrderConverterToDto(OrderConverterToDto orderConverterToDto) {
        this.orderConverterToDto = orderConverterToDto;
    }

    @Autowired
    public void setOrderDtoConverterToOrder(OrderDtoConverterToOrder orderDtoConverterToOrder) {
        this.orderDtoConverterToOrder = orderDtoConverterToOrder;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(userConverterToDto);
        registry.addConverter(userDtoConverterToUser);
        registry.addConverter(roleConverterToDto);
        registry.addConverter(roleDtoConverterToRole);
        registry.addConverter(hotelConverterToDto);
        registry.addConverter(hotelDtoConverterToHotel);
        registry.addConverter(roomConverterToDto);
        registry.addConverter(roomDtoConverterToRoom);
        registry.addConverter(orderConverterToDto);
        registry.addConverter(orderDtoConverterToOrder);
    }
}
