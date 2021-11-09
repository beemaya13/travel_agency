package com.mnilga.travel.agency.spannerintegration.service;

import com.mnilga.travel.agency.spannerintegration.dto.CityDto;
import com.mnilga.travel.agency.spannerintegration.model.City;


public interface CityService {
    CityDto readById(String id);
    City findByName(String name);
    City findById(String id);
}
