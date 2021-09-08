package com.mnilga.travel.agency.fakedata.write;

import com.mnilga.travel.agency.application.model.City;
import com.mnilga.travel.agency.application.model.Country;

public class CityWriter extends Writer<City>{
    private static final String BODY = "('%s')";

    public CityWriter() {
        file_name = "cities.sql";
        header = "INSERT INTO cities (name)\nVALUES ";
    }

    @Override
    protected String prepareValue(City city) {
        return String.format(BODY,
                city.getName().replace("'", "''"));
    }
}
