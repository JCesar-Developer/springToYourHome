package com.losAmos.demoLosAmos.controllers;

import com.losAmos.demoLosAmos.models.entity.User;
import com.losAmos.demoLosAmos.models.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class UserController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public User returnNewUser(){
        return new User();
    }

    @GetMapping
    public String showRegisterForm(Model model){
        model.addAttribute("title", "Registro");
        return "register";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") User user){
        userService.insert(user);
        return "redirect:/register?ok";
    }
}
