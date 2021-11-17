package com.mnilga.travel.agency.application.dto;


import java.util.Objects;
import java.util.UUID;

public class HotelDto {
    private UUID hotelId;
    private String name;
    private Integer stars;
    private Double  square;
    private CityDto cityDto;

    public UUID getHotelId() {
        return hotelId;
    }

    public void setHotelId(UUID hotelId) {
        this.hotelId = hotelId;
    }

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

    public CityDto getCityDto() {
        return cityDto;
    }

    public void setCityDto(CityDto cityDto) {
        this.cityDto = cityDto;
    }

    @Override
    public String toString() {
        return "HotelDto{" +
                "hotelId=" + hotelId +
                ", name='" + name + '\'' +
                ", stars=" + stars +
                ", square=" + square +
                ", cityDto=" + cityDto +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelDto hotelDto = (HotelDto) o;
        return Objects.equals(hotelId, hotelDto.hotelId) && Objects.equals(name, hotelDto.name) && Objects.equals(stars, hotelDto.stars) && Objects.equals(square, hotelDto.square) && Objects.equals(cityDto, hotelDto.cityDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotelId, name, stars, square, cityDto);
    }
}
