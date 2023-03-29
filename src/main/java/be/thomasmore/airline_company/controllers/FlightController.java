package be.thomasmore.airline_company.controllers;

import be.thomasmore.airline_company.model.Flight;
import be.thomasmore.airline_company.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class FlightController {
    @Autowired
    private FlightRepository flightRepository;


    @GetMapping({"/flights"})
    public String flights(Model model, Principal principal) {

        Iterable<Flight> flights = flightRepository.findAll();
        List<Flight> flightsList = (List<Flight>) flights;

        model.addAttribute("showFilter", false);
        model.addAttribute("flights", flightsList);
        model.addAttribute("principal", principal);

        return "flights";
    }

    @GetMapping({"/flights/filter"})
    public String flightsWithFilter(Model model, Principal principal,
                                    @RequestParam(required = false) String country,
                                    @RequestParam(required = false) LocalDate departDate,
                                    @RequestParam(required = false) LocalDate returnDate,
                                    @RequestParam(required = false) String Origin,
                                    @RequestParam(required = false) Integer flightNumber) {

        List<Flight> flights;
        flights = flightRepository.findAllByFilter(country, departDate, returnDate, Origin, flightNumber);

        LocalDate datelimit = LocalDate.now().plusDays(1);

        model.addAttribute("flights", flights);
        model.addAttribute("showFilter", true);
        model.addAttribute("datelimit", datelimit);
        model.addAttribute("principal", principal);

        return "flights";
    }

    @GetMapping({"/flightdetails", "/flightdetails/{id}"})
    public String flightdetails(Model model , Principal principal, @PathVariable(required = false) Integer id) {
        if (id == null) {
            return "flightdetails";
        }
        Optional<Flight> flight = flightRepository.findById(id);

        if (flight.isPresent()) {
            model.addAttribute("flights", flightRepository.findAll());
            model.addAttribute("flight", flight.get());

        }
        model.addAttribute("principal", principal);
        return "flightdetails";
    }


    @PostMapping("/flight/compare")
    public String compareFlights(@RequestParam(name = "selectedFlights", required = false) List<Integer> selectedFlights,
                                 Model model, Principal principal) {

        if (selectedFlights == null || selectedFlights.size() != 2) {
            return "redirect:/flights";
        }

        List<Flight> flightsToCompare = new ArrayList<>();
        for (Integer flightId : selectedFlights) {
            Optional<Flight> optionalFlight = flightRepository.findById(flightId);
            optionalFlight.ifPresent(flightsToCompare::add);
        }

        Flight flight1 = flightsToCompare.get(0);
        Flight flight2 = flightsToCompare.get(1);

        model.addAttribute("flight1", flight1);
        model.addAttribute("flight2", flight2);
        model.addAttribute("flightsToCompare", flightsToCompare);
        model.addAttribute("principal", principal);
        return "flightComparison";
    }

    @GetMapping({"/voegtoe"})
    public String insertFlight(Model model, Principal principal) {

        model.addAttribute("principal", principal);
        return "insertFlight";


    }
    @PostMapping({"/voegtoe"})
    public String toegevoegd(Model model,Principal principal, String flightNumber, String Origin, String omschrijving, LocalDate departureDate, LocalDate returnDate, Integer aircraftId, Integer airportId) {

        Integer flightnr = Integer.valueOf(flightNumber);
        flightRepository.add(flightnr, Origin, omschrijving, departureDate, returnDate, aircraftId, airportId);

        model.addAttribute("principal", principal);

        return "redirect:/flights";


    }

}
