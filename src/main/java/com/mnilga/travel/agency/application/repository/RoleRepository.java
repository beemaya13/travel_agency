package com.mnilga.travel.agency.application.repository;


import com.mnilga.travel.agency.application.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {
    //Role findByName(String name);   ////for security
    Optional<Role> findByName(String name);
}
