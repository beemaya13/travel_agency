package com.mnilga.travel.agency.application.service.impl;

import com.mnilga.travel.agency.application.dto.CityDto;
import com.mnilga.travel.agency.application.dto.CountryDto;
import com.mnilga.travel.agency.application.exceptions.ResourceNotFoundException;
import com.mnilga.travel.agency.application.model.City;
import com.mnilga.travel.agency.application.model.Country;
import com.mnilga.travel.agency.application.repository.CityRepository;
import com.mnilga.travel.agency.application.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CityServiceImpl implements CityService {
    private ConversionService service;
    private CountryServiceImpl countryService;
    private CityRepository cityRepository;

    @Autowired
    public void setCityRepository(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Autowired
    public void setCountryService(CountryServiceImpl countryService) {
        this.countryService = countryService;
    }

    @Autowired
    public void setService(ConversionService service) {
        this.service = service;
    }

    @Override
    public CityDto readById(UUID id) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("City with id = " + id + " not found!"));
        return service.convert(city, CityDto.class);
    }

    @Override
    @Cacheable(value = "cities-cache")
    public City findByName(String name) {
        return cityRepository.findByName(name).orElseThrow(() -> {
            throw new ResourceNotFoundException("City with name =" + name + " does not exist!");
        });
    }

    @Override
    public City findById(UUID id) {
        return cityRepository.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException("City with id =" + id + " does not exist!");
        });
    }

    private void getCountryFromCity(City cityWithCountry) {
        String countryName = cityWithCountry.getCountry().getName();
        Country country = countryService.findByName(countryName);
        cityWithCountry.setCountry(country);
    }
}
