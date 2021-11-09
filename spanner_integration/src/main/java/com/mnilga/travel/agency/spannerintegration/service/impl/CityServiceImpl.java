package com.mnilga.travel.agency.spannerintegration.service.impl;


import com.mnilga.travel.agency.spannerintegration.convertor.CityMapper;
import com.mnilga.travel.agency.spannerintegration.convertor.CountryMapper;
import com.mnilga.travel.agency.spannerintegration.dto.CityDto;
import com.mnilga.travel.agency.spannerintegration.exceptions.ResourceNotFoundException;
import com.mnilga.travel.agency.spannerintegration.model.City;
import com.mnilga.travel.agency.spannerintegration.model.Country;
import com.mnilga.travel.agency.spannerintegration.repository.CityRepository;
import com.mnilga.travel.agency.spannerintegration.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;



@Service
public class CityServiceImpl implements CityService {
    //private ConversionService service;
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

//    @Autowired
//    public void setService(ConversionService service) {
//        this.service = service;
//    }

    @Override
    public CityDto readById(String id) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("City with id = " + id + " not found!"));

        return CityMapper.INSTANCE.cityToCityDto(city);
    }

    @Override
    public City findByName(String name) {
        return cityRepository.findByName(name).orElseThrow(() -> {
            throw new ResourceNotFoundException("City with name =" + name + " does not exist!");
        });
    }

    @Override
    public City findById(String id) {
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
