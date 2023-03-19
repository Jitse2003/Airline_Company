package be.thomasmore.airline_company.controllers;

import be.thomasmore.airline_company.repositories.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AirportController {
    @Autowired
    AirportRepository airportRepository;
}
