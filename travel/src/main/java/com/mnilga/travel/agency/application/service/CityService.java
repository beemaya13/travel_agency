package com.mnilga.travel.agency.application.service;

import com.mnilga.travel.agency.application.dto.CityDto;
import com.mnilga.travel.agency.application.dto.CountryDto;
import com.mnilga.travel.agency.application.model.City;
import com.mnilga.travel.agency.application.model.Country;

import java.util.UUID;

public interface CityService {
    CityDto readById(UUID id);
    City findByName(String name);
}
