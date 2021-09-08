package com.mnilga.travel.agency.fakedata.write;

import com.mnilga.travel.agency.application.model.Country;

public class CountryWriter extends Writer<Country>{
    private static final String BODY = "('%s', '%s', '%s', '%s')";

    public CountryWriter() {
        file_name = "countries.sql";
        header = "INSERT INTO countries (name, ISO, capital, continent)\nVALUES ";
    }

    @Override
    protected String prepareValue(Country country) {
        return String.format(BODY,
                country.getName().replace("'", "''"),
                country.getIso(), country.getCapital().replace("'", "''"),
                country.getContinent().replace("'", "''"));
    }
}
