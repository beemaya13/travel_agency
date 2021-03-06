package com.mnilga.travel.agency.spannerintegration.dto;

import java.util.UUID;

public class CountryDto {

    private String id;
    private String name;
    private String Iso;
    private String capital;
    private String continent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    @Override
    public String toString() {
        return "CountryDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Iso='" + Iso + '\'' +
                ", capital='" + capital + '\'' +
                ", continent='" + continent + '\'' +
                '}';
    }
}
