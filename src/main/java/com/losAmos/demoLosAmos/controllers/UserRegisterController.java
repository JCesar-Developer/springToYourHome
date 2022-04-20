package com.losAmos.demoLosAmos.controllers;

import com.losAmos.demoLosAmos.models.services.UserService;
import com.losAmos.demoLosAmos.models.dto.UserRegisterDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class UserRegisterController {

    private UserService userService;

    public UserRegisterController(UserService userService){
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegisterDTO returnNewUserRegisterDTO(){
        return new UserRegisterDTO();
    }

    @GetMapping
    public String showRegisterForm(){
        return "register";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegisterDTO registerDTO){
        userService.save(registerDTO);
        return "redirect:/register?ok";
    }
}
