package com.losAmos.demoLosAmos.controllers;

import com.losAmos.demoLosAmos.models.entity.Dish;
import com.losAmos.demoLosAmos.models.impl.DishServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(value="", tags="DISHES API REST")
public class DishRestController {

    @Autowired
    private DishServiceImpl dishAPI;

    // ------------------- CREATE & UPDATE -------------------- //
    @PostMapping(value = "/admin/save")
    public ResponseEntity<Dish> dishesRESTSave(@RequestBody Dish dish) {
        Dish newDish = dishAPI.save(dish);
        return new ResponseEntity<Dish>(newDish, HttpStatus.CREATED) ;
    }

    // ------------------------- READ ------------------------- //
    @GetMapping(value = "/open/getOne/{id}")
    public Dish dishesRESTGetOne(@PathVariable Long id) {
        return dishAPI.getOne(id);
    }

    @GetMapping(value = "/open/getAll")
    public List<Dish> dishesRESTGetAll() {
        return dishAPI.getAll();
    }
    // ------------------------ DELETE ------------------------ //
    @PostMapping(value = "/admin/delete/{id}")
    public ResponseEntity<Dish> dishesRESTDelete(@PathVariable Long id) {
        Dish dish = dishAPI.getOne(id);

        if( dish != null ) {
            dishAPI.delete(id);
        } else {
            return new ResponseEntity<Dish>(dish, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Dish>(dish, HttpStatus.OK);
    }

}
