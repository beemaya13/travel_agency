package com.mnilga.travel.agency.fakedata.generate;

import com.mnilga.travel.agency.application.model.Hotel;

public class HotelGenerator extends Generator<Hotel>{
    @Override
    public Hotel generate() {
        Hotel hotel = new Hotel();
        hotel.setName(faker.company().name());
        hotel.setStars(faker.number().numberBetween(1, 6));
        hotel.setSquare(faker.number().randomDouble(2, 10000, 200000));
        return hotel;
    }
}
