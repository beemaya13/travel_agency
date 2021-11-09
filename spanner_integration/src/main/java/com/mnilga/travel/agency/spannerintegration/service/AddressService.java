package com.mnilga.travel.agency.spannerintegration.service;

import com.mnilga.travel.agency.spannerintegration.model.Address;


public interface AddressService {
    Address findById(String id);
}
