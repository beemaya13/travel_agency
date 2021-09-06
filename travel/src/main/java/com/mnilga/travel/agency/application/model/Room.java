package com.mnilga.travel.agency.application.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rooms")
public class Room extends Audit {

    @Column(nullable = false)
    private Integer roomNumber;

    @Column
    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    @Column(nullable = false)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @OneToMany(cascade = CascadeType.ALL,           
            fetch = FetchType.EAGER,
            mappedBy = "room")
    private List<Order> orders = new ArrayList<>();

    public enum RoomType {
        SINGLE, DOUBLE, FAMILY, DELUXE;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
