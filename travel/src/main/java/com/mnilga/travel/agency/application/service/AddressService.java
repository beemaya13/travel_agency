package com.mnilga.travel.agency.application.service;

import com.mnilga.travel.agency.application.model.Address;

import java.util.Optional;
import java.util.UUID;

public interface AddressService {
    Address findById(UUID id);
}
