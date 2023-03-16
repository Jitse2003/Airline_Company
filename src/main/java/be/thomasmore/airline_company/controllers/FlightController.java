package be.thomasmore.airline_company.controllers;

import be.thomasmore.airline_company.model.Flight;
import be.thomasmore.airline_company.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class FlightController {
    @Autowired
    private FlightRepository flightRepository;

    @GetMapping({"/flights"})
    public String flights(Model model) {
        Iterable<Flight> flights = flightRepository.findAll();



        model.addAttribute("flights", flights);

        return "flights";
    }
    @GetMapping({"/flightdetails", "/flightdetails/{id}"})
    public String flightdetails(Model model,  @PathVariable(required = false) Integer id) {
        if (id == null) {
            return "flightdetails";
        }


        Optional<Flight> flight = flightRepository.findById(id);


        model.addAttribute("flight", flight.get());

        return "flightdetails";
    }
}
