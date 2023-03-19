package be.thomasmore.airline_company.repositories;

import be.thomasmore.airline_company.model.Flight;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlightRepository extends CrudRepository<Flight, Integer> {


//    @Query(value = "select f from Flight f where (:capacityMin IS NULL OR :capacityMin <= f.capacity)")
//    List<Flight> findAllByFilter();

}
