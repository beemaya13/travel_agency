package com.mnilga.travel.agency.application.repository;

import com.mnilga.travel.agency.application.model.Address;
import com.mnilga.travel.agency.application.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AddressRepository  extends JpaRepository<Address, UUID> {
    Optional<Address> findById(UUID id);
}
