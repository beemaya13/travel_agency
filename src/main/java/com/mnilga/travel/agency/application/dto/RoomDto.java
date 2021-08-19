package com.mnilga.travel.agency.application.dto;

import java.util.ArrayList;

public class RoomDto {
    private String roomId;
    private String number;
    private String roomType;
    private String price;
    private HotelDto hotel;
//    private List<OrderDto> orders = new ArrayList<>();

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public HotelDto getHotel() {
        return hotel;
    }

    public void setHotel(HotelDto hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "RoomDto{" +
                "roomId='" + roomId + '\'' +
                ", number='" + number + '\'' +
                ", roomType='" + roomType + '\'' +
                ", price='" + price + '\'' +
                ", hotel=" + hotel +
                '}';
    }
}
