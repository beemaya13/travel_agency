package com.mnilga.travel.agency.application.converter;

import com.mnilga.travel.agency.application.dto.HotelDto;
import com.mnilga.travel.agency.application.model.Hotel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class HotelDtoConverterToHotel implements Converter<HotelDto, Hotel> {

    @Override
    public Hotel convert(HotelDto hotelDto) {
        Hotel hotel = new Hotel();
        hotel.setId(hotelDto.getHotelId());
        hotel.setName(hotelDto.getName());
        hotel.setCountry(hotelDto.getCountry());
        hotel.setCity(hotelDto.getCity());
        return hotel;
    }
}
