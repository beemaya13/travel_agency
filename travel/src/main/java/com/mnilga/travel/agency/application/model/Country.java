package com.mnilga.travel.agency.application.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Country country = (Country) o;
        return Objects.equals(name, country.name) && Objects.equals(Iso, country.Iso) && Objects.equals(capital, country.capital) && Objects.equals(continent, country.continent) && Objects.equals(cities, country.cities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, Iso, capital, continent, cities);
    }
}
