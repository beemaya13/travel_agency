package com.mnilga.travel.agency.spannerintegration.model;

import javax.persistence.*;

@Entity
@Table(name = "cities")
public class City extends Audit{

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }


}
