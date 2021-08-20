package com.mnilga.travel.agency.application.converter;


import com.mnilga.travel.agency.application.dto.HotelDto;
import com.mnilga.travel.agency.application.model.Hotel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class HotelConverterToDto implements Converter<Hotel, HotelDto> {

    @Override
    public HotelDto convert(Hotel hotel) {
        HotelDto hotelDto = new HotelDto();
        hotelDto.setHotelId(hotel.getId());
        hotelDto.setName(hotel.getName());
        hotelDto.setCountry(hotel.getCountry());
        hotelDto.setCity(hotel.getCity());
        return hotelDto;
    }
}
