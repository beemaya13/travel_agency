package com.mnilga.travel.agency.application.converter;


import com.mnilga.travel.agency.application.dto.CountryDto;
import com.mnilga.travel.agency.application.dto.HotelDto;
import com.mnilga.travel.agency.application.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class HotelConverterToDto implements Converter<Hotel, HotelDto> {

    private CountryConverterToDto countryConverterToDto;

    @Autowired
    public void setCountryConverterToDto(CountryConverterToDto countryConverterToDto) {
        this.countryConverterToDto = countryConverterToDto;
    }

    @Override
    public HotelDto convert(Hotel hotel) {
        HotelDto hotelDto = new HotelDto();
        hotelDto.setHotelId(hotel.getId());
        hotelDto.setName(hotel.getName());
        CountryDto countryDto = countryConverterToDto.convert(hotel.getCountry());
        hotelDto.setCountry(countryDto);
        hotelDto.setCity(hotel.getCity());
        return hotelDto;
    }
}
