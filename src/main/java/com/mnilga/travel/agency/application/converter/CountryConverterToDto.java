package com.mnilga.travel.agency.application.converter;


import com.mnilga.travel.agency.application.dto.CountryDto;
import com.mnilga.travel.agency.application.model.Country;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CountryConverterToDto implements Converter<Country, CountryDto> {


    @Override
    public CountryDto convert(Country country) {
        CountryDto countryDto = new CountryDto();
        countryDto.setId(country.getId());
        countryDto.setName(country.getName());
        countryDto.setIso(country.getISO());
        countryDto.setCapital(country.getCapital());
        countryDto.setContinent(country.getContinent());
        return countryDto;
    }
}
