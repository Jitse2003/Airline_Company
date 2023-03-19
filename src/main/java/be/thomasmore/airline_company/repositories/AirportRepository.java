package be.thomasmore.airline_company.repositories;

import be.thomasmore.airline_company.model.Airport;
import org.springframework.data.repository.CrudRepository;

public interface AirportRepository extends CrudRepository<Airport, Integer> {

}
