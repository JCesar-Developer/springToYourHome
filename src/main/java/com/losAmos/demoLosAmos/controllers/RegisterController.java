package com.losAmos.demoLosAmos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("title", "Login");
        return "login";
    }

}
