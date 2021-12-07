package com.mnilga.travel.agency.application.dto;


import java.time.LocalDate;
import java.util.Objects;
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

    public UserDto getUserDto() {
        return user;
    }

    public void setUserDto(UserDto user) {
        this.user = user;
    }

    public RoomDto getRoomDto() {
        return room;
    }

    public void setRoomDto(RoomDto room) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDto orderDto = (OrderDto) o;
        return Objects.equals(orderId, orderDto.orderId) && Objects.equals(arrivalDate, orderDto.arrivalDate) && Objects.equals(departureDate, orderDto.departureDate) && Objects.equals(orderDate, orderDto.orderDate) && Objects.equals(user, orderDto.user) && Objects.equals(room, orderDto.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, arrivalDate, departureDate, orderDate, user, room);
    }
}
