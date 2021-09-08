package com.mnilga.travel.agency.fakedata.write;

import com.mnilga.travel.agency.application.model.Order;

public class OrderWriter extends Writer<Order>{
    private static final String BODY = "('%s', '%s')";

    public OrderWriter(){
        file_name = "orders.sql";
        header = "INSERT INTO ORDERS (arrival_date, departure_date)\nVALUES ";
    }

    @Override
    protected String prepareValue(Order order){
        return String.format(BODY, order.getArrivalDate(), order.getDepartureDate());
    }
}
