package com.losAmos.demoLosAmos.controllers;

import com.losAmos.demoLosAmos.models.services.GenericServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DishController {

    @Autowired
    @Qualifier("dishServiceImpl")
    private GenericServiceAPI dishDao;

    //@Autowired
    //private DAOInterface dishDao;

    @GetMapping(value = "/dishManager")
    public String showDishesList(Model model) {
        model.addAttribute("title", "Dishes List");
        model.addAttribute("dishes", dishDao.getAll());
        return "dish/dishManager";
    }

}
