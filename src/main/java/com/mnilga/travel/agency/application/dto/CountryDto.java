package com.mnilga.travel.agency.application.dto;

import java.util.UUID;

public class CountryDto {

    private UUID id;
    private String name;
    private String Iso;
    private String capital;
    private String continent;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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
