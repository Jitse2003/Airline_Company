package be.thomasmore.airline_company.controllers.admin;

import be.thomasmore.airline_company.model.Flight;
import be.thomasmore.airline_company.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping({"/admin"})
@Controller
public class AirlineCompanyAdminController {
    @Autowired
    FlightRepository flightRepository;

    @GetMapping({"/flightdetailsedit/{id}"})
    public String flightdetailsEdit(Model model, @PathVariable(required = false) Integer id) {

        final Iterable<Flight> allFlights = flightRepository.findAll();
        model.addAttribute("flights", allFlights);

        return "admin/flightdetailsedit";
    }

    @ModelAttribute("flight")
    public Flight findFlight(@PathVariable(required = false) Integer id) {
        Optional<Flight> optionalFlight = flightRepository.findById(id);

        if (optionalFlight.isPresent()) {
            return optionalFlight.get();
        }
        return null;
    }

    @PostMapping("/flightdetailsedit/{id}")
    public String flightdetailseditPost(Model model, @PathVariable int id, Flight flight) {
        flightRepository.save(flight);

        return "redirect:/flightdetails/" + id;
    }
}
