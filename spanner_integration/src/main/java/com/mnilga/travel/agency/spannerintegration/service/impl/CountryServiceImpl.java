package com.mnilga.travel.agency.spannerintegration.service.impl;

import com.mnilga.travel.agency.spannerintegration.convertor.CountryMapper;
import com.mnilga.travel.agency.spannerintegration.dto.CountryDto;
import com.mnilga.travel.agency.spannerintegration.exceptions.ResourceNotFoundException;
import com.mnilga.travel.agency.spannerintegration.model.Country;
import com.mnilga.travel.agency.spannerintegration.repository.CountryRepository;
import com.mnilga.travel.agency.spannerintegration.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;


@Service
public class CountryServiceImpl implements CountryService {
    private CountryRepository countryRepository;
//    private ConversionService service;

    @Autowired
    public void setCountryRepository(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

//    @Autowired
//    public void setService(ConversionService service) {
//        this.service = service;
//    }

    @Override
    public CountryDto readById(String id) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Country with id = " + id + " not found!"));
       // return service.convert(country, CountryDto.class);
        return CountryMapper.INSTANCE.countryToCountryDto(country);
    }

    @Override
    public Country findByName(String name) {
        return countryRepository.findByName(name).orElseThrow(() -> {
            throw new ResourceNotFoundException("Country with name =" + name + " does not exist!");
        });
    }
}
