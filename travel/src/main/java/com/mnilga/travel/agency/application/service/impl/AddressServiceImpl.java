package com.mnilga.travel.agency.application.service.impl;

import com.mnilga.travel.agency.application.exceptions.ResourceNotFoundException;
import com.mnilga.travel.agency.application.model.Address;
import com.mnilga.travel.agency.application.model.Hotel;
import com.mnilga.travel.agency.application.model.Role;
import com.mnilga.travel.agency.application.repository.AddressRepository;
import com.mnilga.travel.agency.application.repository.RoleRepository;
import com.mnilga.travel.agency.application.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.UUID;

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
    @Cacheable(value = "address-cache")
    public Address findById(UUID id) {
        return addressRepository.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException("Address with id =" + id + " does not exist!");
        });
    }
}
