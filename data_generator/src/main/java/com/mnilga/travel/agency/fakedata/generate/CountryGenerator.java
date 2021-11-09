package com.mnilga.travel.agency.fakedata.generate;

import com.mnilga.travel.agency.application.model.Country;

public class CountryGenerator extends Generator<Country>{
    @Override
    public Country generate() {
        Country country = new Country();
        country.setName(faker.address().country());
        country.setIso(faker.address().countryCode());
        country.setCapital(faker.address().city());
        country.setContinent(faker.address().country());
        return country;
    }
}
