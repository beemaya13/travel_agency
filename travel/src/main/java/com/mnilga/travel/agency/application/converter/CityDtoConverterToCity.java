package com.mnilga.travel.agency.application.converter;

import com.mnilga.travel.agency.application.dto.CityDto;
import com.mnilga.travel.agency.application.model.City;
import com.mnilga.travel.agency.application.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CityDtoConverterToCity implements Converter<CityDto, City> {

    private CountryDtoConverterToCountry countryDtoConverterToCountry;

    @Autowired
    public void setCountryDtoConverterToCountry(CountryDtoConverterToCountry countryDtoConverterToCountry) {
        this.countryDtoConverterToCountry = countryDtoConverterToCountry;
    }

    @Override
    public City convert(CityDto cityDto) {
        City city = new City();
        city.setId(cityDto.getId());
        city.setName(cityDto.getName());
        Country country = countryDtoConverterToCountry.convert(cityDto.getCountry());
        city.setCountry(country);
        return city;
    }
}
