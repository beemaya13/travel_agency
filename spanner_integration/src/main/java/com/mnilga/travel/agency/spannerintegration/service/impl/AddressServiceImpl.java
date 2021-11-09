package com.mnilga.travel.agency.spannerintegration.service.impl;


import com.mnilga.travel.agency.spannerintegration.exceptions.ResourceNotFoundException;
import com.mnilga.travel.agency.spannerintegration.model.Address;
import com.mnilga.travel.agency.spannerintegration.repository.AddressRepository;
import com.mnilga.travel.agency.spannerintegration.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;


@Service
public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository;
    private ConversionService service;

    @Autowired
    public void setAddressRepository(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Autowired
    public void setService(ConversionService service) {
        this.service = service;
    }

    @Override
    public Address findById(String id) {
        return addressRepository.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException("Address with id =" + id + " does not exist!");
        });
    }
}
