package com.mnilga.travel.agency.spannerintegration.convertor;

import com.mnilga.travel.agency.spannerintegration.dto.CountryDto;
import com.mnilga.travel.agency.spannerintegration.model.Country;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

   // @Mapping(target = "countryId", expression = "java(country.getId())")
    CountryDto countryToCountryDto(Country country);

    Country countryDtoToCountry(CountryDto countryDto);
}
