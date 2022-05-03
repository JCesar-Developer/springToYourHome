package com.losAmos.demoLosAmos.controllers;

import com.losAmos.demoLosAmos.models.entity.Dish;
import com.losAmos.demoLosAmos.models.services.GenericServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dishes")
public class DishRestController {

    @Autowired
    @Qualifier("dishServiceImpl")
    private GenericServiceAPI dishAPI;

    @GetMapping(value = "/getAll")
    public List<Dish> getAllDishesREST() {
        return dishAPI.getAll();
    }

}
