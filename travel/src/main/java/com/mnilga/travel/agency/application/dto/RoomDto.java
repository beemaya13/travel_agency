package com.mnilga.travel.agency.application.dto;

import java.util.Objects;
import java.util.UUID;

public class RoomDto {
    private UUID roomId;
    private Integer roomNumber;
    private String roomType;
    private Double price;
    private HotelDto hotel;

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

    public HotelDto getHotelDto() {
        return hotel;
    }

    public void setHotelDto(HotelDto hotel) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomDto roomDto = (RoomDto) o;
        return Objects.equals(roomId, roomDto.roomId) && Objects.equals(roomNumber, roomDto.roomNumber) && Objects.equals(roomType, roomDto.roomType) && Objects.equals(price, roomDto.price) && Objects.equals(hotel, roomDto.hotel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId, roomNumber, roomType, price, hotel);
    }
}
