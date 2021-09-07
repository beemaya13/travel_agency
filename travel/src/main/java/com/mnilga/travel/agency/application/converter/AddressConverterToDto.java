package com.mnilga.travel.agency.application.converter;

import com.mnilga.travel.agency.application.dto.AddressDto;
import com.mnilga.travel.agency.application.dto.UserDto;
import com.mnilga.travel.agency.application.model.Address;
import com.mnilga.travel.agency.application.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AddressConverterToDto implements Converter<Address, AddressDto> {

    @Override
    public AddressDto convert(Address address) {
        AddressDto addressDto = new AddressDto();
        addressDto.setId(address.getId());
        addressDto.setCountry(address.getCountry());
        addressDto.setCity(address.getCity());
        addressDto.setStreet(address.getStreet());
        addressDto.setHouseNumber(address.getHouseNumber());
        addressDto.setFlatNumber(address.getFlatNumber());
        addressDto.setZipcode(address.getZipcode());
        return addressDto;
    }
}
