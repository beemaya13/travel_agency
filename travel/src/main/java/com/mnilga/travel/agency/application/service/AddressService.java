package com.mnilga.travel.agency.application.service;

import com.mnilga.travel.agency.application.model.Address;

import java.util.Optional;

public interface AddressService {
    Address findByCountryAndCityAndStreetAndHouseNumberAndFlatNumberAndZipcode(String country,
                                                                                         String city,
                                                                                         String street,
                                                                                         Integer house,
                                                                                         Integer flat,
                                                                                         Integer zip);
}
