package com.mnilga.travel.agency.application.dto;

import com.mnilga.travel.agency.application.model.Order;
import com.mnilga.travel.agency.application.model.Room;

import java.util.ArrayList;
import java.util.List;

public class HotelDto {
    private String hotelId;
    private String name;
    private String country;
    private String city;
    private List<RoomDto> rooms = new ArrayList<>();
    private List<OrderDto> orders = new ArrayList<>();


    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "HotelDto{" +
                "hotelId='" + hotelId + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
