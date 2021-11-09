package com.mnilga.travel.agency.spannerintegration.service;


import com.mnilga.travel.agency.spannerintegration.dto.CountryDto;
import com.mnilga.travel.agency.spannerintegration.model.Country;


public interface CountryService {
    CountryDto readById(String id);
    Country findByName(String name);
}
