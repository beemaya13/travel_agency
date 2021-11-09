package com.mnilga.travel.agency.spannerintegration.convertor;

import com.mnilga.travel.agency.spannerintegration.dto.AddressDto;
import com.mnilga.travel.agency.spannerintegration.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

   // @Mapping(target = "addressId", expression = "java(address.getId())")
    AddressDto addressToAddressDto(Address address);

    Address addressDtoToAddress(AddressDto addressDto);
}
