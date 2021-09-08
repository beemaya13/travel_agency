package com.mnilga.travel.agency.fakedata.generate;

import com.mnilga.travel.agency.application.model.Address;

public class AddressGenerator extends Generator<Address> {

    @Override
    public Address generate() {
        Address address = new Address();
        address.setCountry(faker.address().country());
        address.setCity(faker.address().city());
        address.setStreet(faker.address().streetAddress());
        address.setHouseNumber(faker.number().numberBetween(1, 1000));
        address.setFlatNumber(faker.number().numberBetween(1, 1000));
        address.setZipcode(faker.number().numberBetween(10000, 99999));
        return address;
    }
}
