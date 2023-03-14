package be.thomasmore.airline_company.repositories;

import be.thomasmore.airline_company.model.Flight;
import org.springframework.data.repository.CrudRepository;

public interface FlightRepository extends CrudRepository<Flight, Integer> {

}
