package com.mnilga.travel.agency.application.converter;

import com.mnilga.travel.agency.application.dto.CountryDto;
import com.mnilga.travel.agency.application.model.Country;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CountryDtoConverterToCountry implements Converter<CountryDto, Country> {

    @Override
    public Country convert(CountryDto countryDto) {
        Country country = new Country();
        country.setId(countryDto.getId());
        country.setName(countryDto.getName());
        country.setIso(countryDto.getIso());
        country.setCapital(countryDto.getCapital());
        country.setContinent(countryDto.getContinent());
        return country;
    }
}
