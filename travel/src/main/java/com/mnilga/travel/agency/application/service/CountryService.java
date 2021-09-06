package com.mnilga.travel.agency.application.service;

import com.mnilga.travel.agency.application.dto.CountryDto;
import com.mnilga.travel.agency.application.model.Country;

import java.util.UUID;

public interface CountryService {
    public CountryDto readById(UUID id);
    public Country findByName(String name);
}
