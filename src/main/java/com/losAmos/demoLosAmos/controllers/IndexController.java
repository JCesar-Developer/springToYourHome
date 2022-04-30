package com.losAmos.demoLosAmos.controllers;

import com.losAmos.demoLosAmos.models.services.GenericServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    @Qualifier("dishServiceImpl")
    private GenericServiceAPI dishAPI;

    /**
     * Routing INDEX URL.
     * @param model
     * @return
     */
    @GetMapping( value = {"", "/", "/index"} )
    public String getIndex(Model model) {
        model.addAttribute("title", "Índice");
        model.addAttribute("dishes", dishAPI.getAll());
        return "index";
    }

}
