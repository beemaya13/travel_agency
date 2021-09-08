package com.mnilga.travel.agency.fakedata.write;

import com.mnilga.travel.agency.application.model.Hotel;

public class HotelWriter extends Writer<Hotel> {
    private static final String BODY = "('%s', '%s', '%s')";

    public HotelWriter() {
        file_name = "hotels.sql";
        header = "INSERT INTO HOTELS (name, stars, square)\nVALUES ";
    }

    @Override
    protected String prepareValue(Hotel hotel) {
        return String.format(BODY, hotel.getName().replace("'", "''"),
                hotel.getStars(), hotel.getSquare());
    }
}
