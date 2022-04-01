package com.losAmos.demoLosAmos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
//Defining the root route.
public class RoutesManager {

    /**
     * Routing INDEX URL.
     * @param model
     * @return
     */
    @GetMapping(value = "/")
    public String getIndex(Model model) { return "index"; }

}
