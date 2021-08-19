package com.mnilga.travel.agency.application.repository;

import com.mnilga.travel.agency.application.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository <User, UUID>{

//    User findByLogin(String login);   ////for security

}
