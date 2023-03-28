package be.thomasmore.airline_company.repositories;

import be.thomasmore.airline_company.model.Flight;
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
            "(:returnDate IS NULL OR f.returnDate = :returnDate)")
    List<Flight> findAllByFilter(@Param("country") String country,
                                 @Param("departureDate") LocalDate departureDate,
                                 @Param("returnDate") LocalDate returnDate);

}
