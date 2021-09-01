package com.mnilga.travel.agency.application.service.impl;

import com.mnilga.travel.agency.application.dto.CountryDto;
import com.mnilga.travel.agency.application.dto.HotelDto;
import com.mnilga.travel.agency.application.exceptions.ResourceNotFoundException;
import com.mnilga.travel.agency.application.model.Country;
import com.mnilga.travel.agency.application.model.Hotel;
import com.mnilga.travel.agency.application.model.Role;
import com.mnilga.travel.agency.application.repository.CountryRepository;
import com.mnilga.travel.agency.application.repository.HotelRepository;
import com.mnilga.travel.agency.application.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CountryServiceImpl implements CountryService {
    private CountryRepository countryRepository;
    private ConversionService service;

    @Autowired
    public void setCountryRepository(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Autowired
    public void setService(ConversionService service) {
        this.service = service;
    }

    @Override
    public CountryDto readById(UUID id) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Country with id = " + id + " not found!"));
        return service.convert(country, CountryDto.class);
    }

    @Override
    public Country findByName(String name) {
        return countryRepository.findByName(name).orElseThrow(() -> {
            throw new ResourceNotFoundException("Country with name =" + name + " does not exist!");
        });
    }
}
