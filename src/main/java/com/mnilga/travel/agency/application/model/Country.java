package com.mnilga.travel.agency.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
public class Country extends Audit{

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, length = 3)
    private String Iso;

    @Column(nullable = false)
    private String capital;

    @Column(nullable = false)
    private String continent;

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
}
