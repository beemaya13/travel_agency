package com.mnilga.travel.agency.application.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "countries")
public class Country extends Audit{

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, length = 2)
    private String Iso;

    @Column(nullable = false)
    private String capital;

    @Column(nullable = false)
    private String continent;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "country")
    private List<City> cities = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIso() {
        return Iso;
    }

    public void setIso(String iso) {
        Iso = iso;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
