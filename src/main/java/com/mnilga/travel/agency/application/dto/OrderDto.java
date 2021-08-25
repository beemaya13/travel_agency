package com.mnilga.travel.agency.application.dto;

import com.mnilga.travel.agency.application.model.Hotel;
import com.mnilga.travel.agency.application.model.Room;

import java.time.LocalDate;
import java.util.UUID;

public class OrderDto {
    private UUID orderId = UUID.randomUUID();
    private UserDto user = new UserDto();
    private HotelDto hotel = new HotelDto();
    private RoomDto room = new RoomDto();
    private LocalDate arrivalDate = LocalDate.ofEpochDay(0);
    private LocalDate departureDate = LocalDate.ofEpochDay(0);
    private LocalDate orderDate = LocalDate.ofEpochDay(0);

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public HotelDto getHotel() {
        return hotel;
    }

    public void setHotel(HotelDto hotel) {
        this.hotel = hotel;
    }

    public RoomDto getRoom() {
        return room;
    }

    public void setRoom(RoomDto room) {
        this.room = room;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "orderId='" + orderId + '\'' +
                ", user=" + user +
                ", hotel=" + hotel +
                ", room=" + room +
                ", arrivalDate='" + arrivalDate + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", orderDate='" + orderDate + '\'' +
                '}';
    }
}
