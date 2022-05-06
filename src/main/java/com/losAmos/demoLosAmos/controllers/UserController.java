package com.losAmos.demoLosAmos.controllers;

import com.losAmos.demoLosAmos.models.entity.User;
import com.losAmos.demoLosAmos.models.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    //TODO: ¿PUEDE QUE NECESITEMOS MOVER ESTAS FUNCIONES A LOGIN CONTROLLER?
    //      ¿Y HACER DE USER CONTROLLER ESPECIAL PARA CRUD?

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegisterForm(@ModelAttribute User user, Model model){
        model.addAttribute("title", "Registro");
        model.addAttribute("user", user);
        return "register";
    }

    @GetMapping("/user/myaccount")
    public String getMyAccount(@ModelAttribute User user, Model model){
        model.addAttribute("title", "Mi Cuenta");
        model.addAttribute("user", user);
        return "myaccount";
    }
    @GetMapping("/admin/myaccount")
    public String getAdminAccount(@ModelAttribute User user, Model model){
        model.addAttribute("title", "Mi Cuenta");
        model.addAttribute("user", user);
        return "myaccount";
    }

    @PostMapping("/register")
    public String registerUserAccount(@Valid User user, BindingResult bindingResult){

        if(bindingResult.hasErrors()) {
            return "register";
        }

        userService.insert(user);
        return "redirect:/login?ok";
    }
}
