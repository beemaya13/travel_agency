package com.mnilga.travel.agency.application.converter;

import com.mnilga.travel.agency.application.dto.AddressDto;
import com.mnilga.travel.agency.application.model.Address;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AddressDtoConverterToAddress implements Converter<AddressDto, Address> {

    @Override
    public Address convert(AddressDto addressDto) {
        Address address = new Address();
        address.setId(addressDto.getId());
        address.setCountry(addressDto.getCountry());
        address.setCity(addressDto.getCity());
        address.setStreet(addressDto.getStreet());
        address.setHouseNumber(addressDto.getHouseNumber());
        address.setFlatNumber(addressDto.getFlatNumber());
        address.setZipcode(addressDto.getZipcode());
        return address;
    }
}
