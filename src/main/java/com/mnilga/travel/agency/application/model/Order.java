package com.mnilga.travel.agency.application.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order extends Audit{

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user = new User();

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel = new Hotel();

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room = new Room();

    @Column(name = "arrival_date", nullable = false)
    private LocalDate arrivalDate = LocalDate.ofEpochDay(0);

    @Column(name = "departure_date", nullable = false)
    private LocalDate departureDate = LocalDate.ofEpochDay(0);

    @Column(name = "order_date", nullable = false)
    private LocalDate orderDate = LocalDate.ofEpochDay(0);

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
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
}
