package com.mnilga.travel.agency.spannerintegration.convertor;

import com.mnilga.travel.agency.spannerintegration.dto.CityDto;
import com.mnilga.travel.agency.spannerintegration.model.City;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CityMapper {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

   // @Mapping(target = "cityId", expression = "java(city.getId())")
    CityDto cityToCityDto(City city);

    City cityDtoToCity(CityDto cityDto);
}
