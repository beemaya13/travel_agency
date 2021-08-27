package com.mnilga.travel.agency.application.converter;

import com.mnilga.travel.agency.application.dto.HotelDto;
import com.mnilga.travel.agency.application.model.Country;
import com.mnilga.travel.agency.application.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class HotelDtoConverterToHotel implements Converter<HotelDto, Hotel> {

    private CountryDtoConverterToCountry countryDtoConverterToCountry;

    @Autowired
    public void setCountryDtoConverterToCountry(CountryDtoConverterToCountry countryDtoConverterToCountry) {
        this.countryDtoConverterToCountry = countryDtoConverterToCountry;
    }

    @Override
    public Hotel convert(HotelDto hotelDto) {
        Hotel hotel = new Hotel();
        hotel.setId(hotelDto.getHotelId());
        hotel.setName(hotelDto.getName());
        Country country = countryDtoConverterToCountry.convert(hotelDto.getCountry());
        hotel.setCountry(country);
        hotel.setCity(hotelDto.getCity());
        return hotel;
    }
}
