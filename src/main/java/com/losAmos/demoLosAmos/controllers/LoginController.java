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
            flash.addFlashAttribute("info", "Error: Ya hay una sesión actualmente inicializada.");
            return "redirect:/";
        }
        if ( error != null ) {
            model.addAttribute("error", "Error: Nombre de usuario o contraseña incorrecta, por favor, vuelva a intentarlo.");
        }

        return "login";

    }

}
