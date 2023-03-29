package be.thomasmore.airline_company.controllers;

import be.thomasmore.airline_company.model.Flight;
import be.thomasmore.airline_company.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Optional;

@Controller
public class HomeController {
    @Autowired
    private FlightRepository flightRepository;
    @GetMapping({"/","/index"})
    public String home(Model model, Principal principal){
        model.addAttribute("principal", principal);
        return "index";
    }
    @GetMapping({"/about"})
    public String about(Model model, Principal principal){
        Iterable<Flight> flights = flightRepository.findAll();

        model.addAttribute("flights", flights);
        model.addAttribute("principal", principal);
        return "about";
    }

    @GetMapping({"/contact"})
    public String contact(Model model, Principal principal){
        model.addAttribute("principal", principal);
        return "contact";
    }

    @GetMapping({"/book"})
    public String book(Model model, Principal principal){
        model.addAttribute("principal", principal);
        return "book";
    }
    @GetMapping({"/bookConfirm"})
    public String bookConfirm(Model model, Principal principal){
        model.addAttribute("principal", principal);
        return "bookConfirm";
    }
}
