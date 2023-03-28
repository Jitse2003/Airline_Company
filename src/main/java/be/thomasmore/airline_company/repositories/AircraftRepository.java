package be.thomasmore.airline_company.repositories;

import be.thomasmore.airline_company.model.Aircraft;
import org.springframework.data.repository.CrudRepository;

public interface AircraftRepository extends CrudRepository<Aircraft, Integer> {

}
