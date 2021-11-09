package com.mnilga.travel.agency.spannerintegration.repository;


import com.mnilga.travel.agency.spannerintegration.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
    Optional<Role> findByName(String name);
}
