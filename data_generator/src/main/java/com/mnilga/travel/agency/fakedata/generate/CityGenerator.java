package com.mnilga.travel.agency.fakedata.generate;

import com.mnilga.travel.agency.application.model.City;
import com.mnilga.travel.agency.application.model.Country;

public class CityGenerator extends Generator<City>{
    @Override
    public City generate() {
        City city = new City();
        city.setName(faker.address().cityName());
        return city;
    }
}
