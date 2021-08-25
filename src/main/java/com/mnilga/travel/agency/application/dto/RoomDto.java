package com.mnilga.travel.agency.application.dto;

import java.util.UUID;

public class RoomDto {
    private UUID roomId = UUID.randomUUID();
    private Integer roomNumber = 0;
    private String roomType = "";
    private Double price = 0.0;
    private HotelDto hotel = new HotelDto();
//    private List<OrderDto> orders = new ArrayList<>();


    public UUID getRoomId() {
        return roomId;
    }

    public void setRoomId(UUID roomId) {
        this.roomId = roomId;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
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
                ", number='" + roomNumber + '\'' +
                ", roomType='" + roomType + '\'' +
                ", price='" + price + '\'' +
                ", hotel=" + hotel +
                '}';
    }
}
