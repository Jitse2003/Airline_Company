package be.thomasmore.airline_company.controllers;

import be.thomasmore.airline_company.model.Flight;
import be.thomasmore.airline_company.repositories.FlightRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class FlightController {
    private FlightRepository flightRepository;

    @GetMapping({"/flights"})
    public String flights(Model model) {
        Iterable<Flight> flights = flightRepository.findAll();



        model.addAttribute("flights", flights);

        return "flights";
    }
}
