package be.thomasmore.airline_company.repositories;

import be.thomasmore.airline_company.model.Flight;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface FlightRepository extends CrudRepository<Flight, Integer> {


    @Query("SELECT f FROM Flight f WHERE " +
            "(:country IS NULL OR f.airport.country ILIKE %:country%) AND " +
            "(:departureDate IS NULL OR f.departureDate = :departureDate) AND " +
            "(:returnDate IS NULL OR f.returnDate = :returnDate) AND " +
            "(:Origin IS NULL OR f.origin  ILIKE %:Origin%) AND " +
            "(:flightNumber IS NULL OR f.flightNumber = :flightNumber)")
    List<Flight> findAllByFilter(@Param("country") String country,
                                 @Param("departureDate") LocalDate departureDate,
                                 @Param("returnDate") LocalDate returnDate,
                                 @Param("Origin") String Origin,
                                 @Param("flightNumber") Integer flightNumber
    );


    @Transactional
    @Modifying
    @Query(value = "insert into flight (flight_Number, Origin, omschrijving, departure_Date, return_Date, aircraft_Id, airport_Id) values(:flightNumber, :Origin, :omschrijving, :departureDate, :returnDate, :aircraftId, :airportId)", nativeQuery = true)
    void add(
            @Param("flightNumber") Integer flightNumber,
            @Param("Origin") String Origin,
            @Param("omschrijving") String omschrijving,
            @Param("departureDate") LocalDate departureDate,
            @Param("returnDate") LocalDate returnDate,
            @Param("aircraftId") Integer aircraftId,
            @Param("airportId") Integer airportId
    );
}
