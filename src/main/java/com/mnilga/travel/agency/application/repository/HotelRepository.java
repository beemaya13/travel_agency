package com.mnilga.travel.agency.application.repository;

import com.mnilga.travel.agency.application.model.Hotel;
import com.mnilga.travel.agency.application.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, UUID> {
    Optional<Hotel> findByName(String name);
    Optional<Hotel> findById(UUID id);
    Optional<Hotel> findByCountry(String name);
}
