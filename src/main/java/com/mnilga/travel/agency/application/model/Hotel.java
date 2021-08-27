package com.mnilga.travel.agency.application.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hotels")
public class Hotel extends Audit{

    @Column(unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;

    @Column
    private String city;            //????  move to Country class

    @OneToMany(cascade = CascadeType.ALL,
    mappedBy = "hotel")
    private List<Room> rooms = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,
    mappedBy = "hotel")
    private List<Order> orders = new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
