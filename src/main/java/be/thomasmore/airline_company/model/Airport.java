package be.thomasmore.airline_company.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Airport {
    @Id
    private Integer id;
    private String name, city, country;

    @OneToMany(mappedBy = "airport")
    private Collection<Flight> flights;

    @OneToMany(mappedBy = "airport")
    private Collection<Aircraft> aircraft;
    public Airport() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public Collection<Aircraft> getAircraft() {
        return aircraft;
    }

    public void setAircraft(Collection<Aircraft> aircraft) {
        this.aircraft = aircraft;
    }
}
