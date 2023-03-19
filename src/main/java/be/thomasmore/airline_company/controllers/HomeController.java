package be.thomasmore.airline_company.controllers;

import be.thomasmore.airline_company.model.Flight;
import be.thomasmore.airline_company.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class HomeController {
    @Autowired
    private FlightRepository flightRepository;
    @GetMapping({"/","/index"})
    public String home(){

        return "index";
    }
    @GetMapping({"/about"})
    public String about(Model model){
        Iterable<Flight> flights = flightRepository.findAll();

        model.addAttribute("flights", flights);

        return "about";
    }

    @GetMapping({"/contact"})
    public String contact(){

        return "contact";
    }

    @GetMapping({"/book"})
    public String book(){

        return "book";
    }
}
