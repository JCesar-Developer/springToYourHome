package com.losAmos.demoLosAmos.controllers;
import com.losAmos.demoLosAmos.models.dao.IDishDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DishController {

    @Autowired
    private IDishDao dishDao;

    @GetMapping(value = "/dishesList")
    public String showDishesList(Model model) {
        model.addAttribute("title", "Dishes List");
        model.addAttribute("dishes", dishDao.getAll());
        return "dish/dishesList";
    }

}
