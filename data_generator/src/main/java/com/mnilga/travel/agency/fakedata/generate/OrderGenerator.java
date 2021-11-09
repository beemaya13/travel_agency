package com.mnilga.travel.agency.fakedata.generate;

import com.mnilga.travel.agency.application.model.Order;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class OrderGenerator extends Generator<Order>{

    @Override
    public Order generate() {
        Order order = new Order();
        order.setArrivalDate(faker.date()
                .between(Date.from(Instant.parse("2021-09-01T00:00:00.000Z")),
                        Date.from(Instant.parse("2022-12-01T00:00:00.000Z")))
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate());

        order.setDepartureDate(faker.date()
                .between(Date.from(Instant.parse("2021-10-01T00:00:00.000Z")),
                        Date.from(Instant.parse("2022-12-01T00:00:00.000Z")))
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate());
        return order;
    }
}
