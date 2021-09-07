package com.mnilga.travel.agency.application.converter;


import com.mnilga.travel.agency.application.dto.CityDto;
import com.mnilga.travel.agency.application.dto.CountryDto;
import com.mnilga.travel.agency.application.dto.HotelDto;
import com.mnilga.travel.agency.application.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class HotelConverterToDto implements Converter<Hotel, HotelDto> {

    private CityConverterToDto cityConverterToDto;

    @Autowired
    public void setCityConverterToDto(CityConverterToDto cityConverterToDto) {
        this.cityConverterToDto = cityConverterToDto;
    }

    @Override
    public HotelDto convert(Hotel hotel) {
        HotelDto hotelDto = new HotelDto();
        hotelDto.setHotelId(hotel.getId());
        hotelDto.setName(hotel.getName());
        hotelDto.setStars(hotel.getStars());
        hotelDto.setSquare(hotel.getSquare());
        CityDto cityDto = cityConverterToDto.convert(hotel.getCity());
        hotelDto.setCityDto(cityDto);
        return hotelDto;
    }
}
