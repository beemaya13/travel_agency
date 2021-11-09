package com.mnilga.travel.agency.fakedata.write;

import com.mnilga.travel.agency.application.model.Address;

public class AddressWriter extends Writer<Address>{

    private static final String BODY = "('%s', '%s', '%s', '%s', '%s', '%s')";

    public AddressWriter() {
        file_name = "addresses.sql";
        header = "INSERT INTO ADDRESSES (country, city, street, house_number, flat_number, zipcode)\nVALUES ";
    }

    @Override
    protected String prepareValue(Address address) {
        return String.format(BODY, address.getCountry().replace("'", "''"),
                address.getCity().replace("'", "''"), address.getStreet().replace("'", "''"), address.getHouseNumber().toString(),
                address.getFlatNumber().toString(), address.getZipcode().toString());
    }
}
