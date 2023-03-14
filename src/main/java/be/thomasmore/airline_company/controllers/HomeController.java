package be.thomasmore.airline_company.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/","/index"})
    public String home(){

        return "index";
    }
    @GetMapping({"/about"})
    public String about(){

        return "about";
    }

}
