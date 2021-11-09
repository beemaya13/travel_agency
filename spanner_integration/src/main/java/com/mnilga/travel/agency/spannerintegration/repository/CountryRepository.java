package com.mnilga.travel.agency.spannerintegration.repository;

import com.mnilga.travel.agency.spannerintegration.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
    Optional<Country> findByName(String name);
}
