package com.mnilga.travel.agency.application.model;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class UserAddress extends Audit {

    @Column(nullable = false)
    private String street;

    @Column(name = "house_number", nullable = false)
    private Integer houseNumber;

    @Column(name = "flat_number", nullable = false)
    private Integer flatNumber;


    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String city;

    @OneToMany
    @JoinColumn(name = "user_id")
    private User user;
}
