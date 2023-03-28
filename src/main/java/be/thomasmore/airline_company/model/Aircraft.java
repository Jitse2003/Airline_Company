package be.thomasmore.airline_company.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Aircraft {
    @Id
    private Integer id;
    private int capacity;
    private String manufacturer;
    private String model;

    @ManyToOne(optional = false)
    private Airport airport;

    @OneToMany(mappedBy = "aircraft")
    private Collection<Flight> flight;

    public Aircraft() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public Collection<Flight> getFlight() {
        return flight;
    }

    public void setFlight(Collection<Flight> flight) {
        this.flight = flight;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }
}
