package com.mnilga.travel.agency.spannerintegration.repository;

import com.mnilga.travel.agency.spannerintegration.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository  extends JpaRepository<City, String> {
    Optional<City> findByName(String name);
    Optional<City> findById(String id);
}
