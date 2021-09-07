package com.mnilga.travel.agency.application.converter;

import com.mnilga.travel.agency.application.dto.HotelDto;
import com.mnilga.travel.agency.application.model.City;
import com.mnilga.travel.agency.application.model.Country;
import com.mnilga.travel.agency.application.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class HotelDtoConverterToHotel implements Converter<HotelDto, Hotel> {

    private CityDtoConverterToCity cityDtoConverterToCity;

    @Autowired
    public void setCityDtoConverterToCity(CityDtoConverterToCity cityDtoConverterToCity) {
        this.cityDtoConverterToCity = cityDtoConverterToCity;
    }

    @Override
    public Hotel convert(HotelDto hotelDto) {
        Hotel hotel = new Hotel();
        hotel.setId(hotelDto.getHotelId());
        hotel.setName(hotelDto.getName());
        hotel.setStars(hotelDto.getStars());
        hotel.setSquare(hotelDto.getSquare());
        City city = cityDtoConverterToCity.convert(hotelDto.getCityDto());
        hotel.setCity(city);
        return hotel;
    }
}
