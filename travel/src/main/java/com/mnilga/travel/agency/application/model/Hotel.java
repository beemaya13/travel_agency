package com.mnilga.travel.agency.application.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hotels")
public class Hotel extends Audit{

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Integer stars;

    @Column(nullable = false)
    private Double square;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @OneToMany(cascade = CascadeType.ALL,
    mappedBy = "hotel")
    private List<Room> rooms = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public Double getSquare() {
        return square;
    }

    public void setSquare(Double square) {
        this.square = square;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
