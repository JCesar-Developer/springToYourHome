package com.losAmos.demoLosAmos.controllers;

import com.losAmos.demoLosAmos.models.entity.Dish;
import com.losAmos.demoLosAmos.models.impl.DishServiceImpl;
import com.losAmos.demoLosAmos.models.services.GenericServiceAPI;
import com.losAmos.demoLosAmos.models.services.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class DishController {

    // -------------------------- ATRIBUTES -------------------------- //

    @Autowired
    @Qualifier("dishServiceImpl")
    private GenericServiceAPI dishAPI;

    // ----------------------- API REST ROUTES ----------------------- //
    /**
     * WHEN YOU USE THIS ROUTE: You're going to go to the root route of dish manager.
     * @apiNote you're sending a list done for the getAll() methode from dishAPI
     * @return shows view: "dishManager"
     */
    @GetMapping(value = "/dishManager")
    public String showDishesList(Model model) {
        model.addAttribute("title", "Lista de platos");
        model.addAttribute("dishes", dishAPI.getAll());
        return "dish/dishManager";
    }

    /**
     * WHEN YOU USE THIS ROUTE: You're going to show a pop-up to INSERT or UPDATE one dish.
     * @apiNote if the (dish_Id == null) : you'll create a new dish;
     * @apiNote if the (dish_id != null) : you'll update an old dish;
     * @return shows pop-up view: "dishManager/save"
     */
    @GetMapping("/dishManager/save/{id}")
    public String showSaveNewDish(@PathVariable("id") Long id, Model model) {
        if( id != null && id != 0) {
            model.addAttribute( "dish", dishAPI.getOne(id));
        }//end if
        else {
            model.addAttribute("dish", new Dish());
        }
        return "dish/addNewDish";
    }

    /**
     * WHEN YOU USE THIS ROUTE: You're going to use the save() method from the dishAPI.
     * @return shows view: "dishManager"
     */
    @PostMapping("/dishManager/save")
    public String saveDish(@Valid Dish dish, BindingResult result, Model model) {
        //VALIDATION
        if( result.hasErrors() ){
            return "dish/addNewDish";
        }
        //END VALIDATION

        dishAPI.save(dish);
        return "redirect:/dishManager";
    }

    /**
     * WHEN YOU USE THIS ROUTE: You're going to use the delete() method from the dishAPI.
     * @return shows view: "dishManager"
     */
    @GetMapping("/dishManager/delete/{id}")
    public String deleteDish(@PathVariable Long id, Model model) {
        dishAPI.delete(id);
        return "redirect:/dishManager";
    }

}
