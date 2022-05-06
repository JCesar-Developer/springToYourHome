package com.losAmos.demoLosAmos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginView(@RequestParam(value="error", required = false) String error,
            Model model, Principal principal, RedirectAttributes flash){

        model.addAttribute("title", "Login");

        if( principal != null ) {
            flash.addFlashAttribute("info", "Ya hay una sesión actualmente inicializada.");
            return "redirect:/";
        }
        if ( error != null ) {
            model.addAttribute("error", "Nombre de usuario o contraseña incorrecta. Inténtelo de nuevo.");
        }

        return "login";

    }

//    @GetMapping("/login/login")
//    public String login(@RequestParam(value="error", required = false) String error,
//            Model model, RedirectAttributes flash){
//
//        flash.addFlashAttribute("loginSuccess", "");
//        return "redirect:/";
//    }

}
