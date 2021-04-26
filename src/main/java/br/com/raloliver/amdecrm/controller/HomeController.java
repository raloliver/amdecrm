package br.com.raloliver.amdecrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {

    // @RequestMapping(path = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public String home() {
        return "home";
    }

}
