package be.thomasmore.airline_company.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

@Entity
public class Flight {
    @Id
    private Integer id;
private Integer flightNumber;
private String destination, omschrijving, maatschapij;

@Temporal(TemporalType.DATE)
private Date departureDate, returnDate;

    public Flight() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Integer flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public String getMaatschapij() {
        return maatschapij;
    }

    public void setMaatschapij(String maatschapij) {
        this.maatschapij = maatschapij;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
