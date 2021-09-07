package com.mnilga.travel.agency.application.converter;

import com.mnilga.travel.agency.application.dto.CityDto;
import com.mnilga.travel.agency.application.dto.CountryDto;
import com.mnilga.travel.agency.application.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CityConverterToDto implements Converter<City, CityDto> {
    private CountryConverterToDto countryConverterToDto;

    @Autowired
    public void setCountryConverterToDto(CountryConverterToDto countryConverterToDto) {
        this.countryConverterToDto = countryConverterToDto;
    }

    @Override
    public CityDto convert(City city) {
        CityDto cityDto = new CityDto();
        cityDto.setId(city.getId());
        cityDto.setName(city.getName());
        CountryDto countryDto = countryConverterToDto.convert(city.getCountry());
        cityDto.setCountry(countryDto);
        return cityDto;
    }
}
