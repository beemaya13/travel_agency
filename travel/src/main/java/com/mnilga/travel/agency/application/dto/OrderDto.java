package com.mnilga.travel.agency.application.dto;


import java.time.LocalDate;
import java.util.UUID;

public class OrderDto {
    private UUID orderId;
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private LocalDate orderDate;
    private UserDto user;
    private RoomDto room;

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
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

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public RoomDto getRoom() {
        return room;
    }

    public void setRoom(RoomDto room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "orderId=" + orderId +
                ", arrivalDate=" + arrivalDate +
                ", departureDate=" + departureDate +
                ", orderDate=" + orderDate +
                ", user=" + user +
                ", room=" + room +
                '}';
    }
}
