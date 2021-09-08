package com.mnilga.travel.agency.application.repository;

import com.mnilga.travel.agency.application.model.Address;
import com.mnilga.travel.agency.application.model.City;
import com.mnilga.travel.agency.application.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CityRepository  extends JpaRepository<City, UUID> {
    Optional<City> findByName(String name);
    Optional<City> findById(UUID id);
}
