package com.losAmos.demoLosAmos.controllers;

import com.losAmos.demoLosAmos.models.entity.Dish;
import com.losAmos.demoLosAmos.models.impl.CategoryServiceImpl;
import com.losAmos.demoLosAmos.models.services.GenericServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class DishController {

    // -------------------------- ATRIBUTES -------------------------- //
    @Autowired
    @Qualifier("dishServiceImpl")
    private GenericServiceAPI dishAPI;

    @Autowired
    @Qualifier("categoryServiceImpl")
    private GenericServiceAPI categoryAPI;

    @Autowired
    @Qualifier("labelServiceImpl")
    private GenericServiceAPI labelAPI;

    // ----------------------- API REST ROUTES ----------------------- //
    /**
     * WHEN YOU USE THIS ROUTE: You're going to go to the root route of dish manager.
     * @apiNote you're sending a list done for the getAll() methode from dishAPI
     * @return shows view: "dishManager"
     */
    @GetMapping(value = "/dishManager")
    public String showDishesList(Model model) {
        model.addAttribute("title", "Panel de Administración");
        model.addAttribute("dishes", dishAPI.getAll());
        model.addAttribute( "categories", categoryAPI.getAll());
        model.addAttribute( "labels", labelAPI.getAll());
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
        model.addAttribute( "categories", categoryAPI.getAll());
        model.addAttribute( "labels", labelAPI.getAll());

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
    public String saveDish(@Valid Dish dish, BindingResult result, Model model,
                           @RequestParam("file")MultipartFile image) {
        //VALIDATION
        if( result.hasErrors() ){
            model.addAttribute( "categories", categoryAPI.getAll());
            model.addAttribute( "labels", labelAPI.getAll());
            return "dish/addNewDish";
        }//end if
        //AL CREAR: Si no hay imagen
        else if ( image.isEmpty() && (dish.getId() == null) ) {
            //TODO: LANZAR VALIDACIÓN: ERROR
            return "redirect:/dishManager";
        }
        //AL CREAR: Si imagen no está vacía -> CREA EL REGISTRO
        else if( !image.isEmpty() && (dish.getImage() == null) ){
            Path imagesDirectory = Paths.get("src//main//resources//static/images");
            String absolutePath = imagesDirectory.toFile().getAbsolutePath();

            try {
                byte[] bytesImg = image.getBytes();
                Path fullPath = Paths.get(absolutePath + "//" + image.getOriginalFilename());
                Files.write(fullPath, bytesImg);

                dish.setImage(image.getOriginalFilename());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //AL MODIFICAR: Si la imagen está vacia pero el registro ya tiene una imagen -> No eliminar imagen anterior
        else if ( dish.getImage() != null ) {
            //TODO: No eliminar imagen anterior
            /* ANTES, HAY QUE IMPLEMENTAR TODO LO DEL VIDEO.
             * NOTA: AL PASAR EL DEBUGGADOR EL MÉTODO GET IMAGE SALE VACIO.
             * SE PLANTEA LA IDEA DE METER LA IMAGEN EN UN ARRAY Y ESTABLECER UN
             * MÉTODO BOOLEANO QUE RECORRA EL ARRAY BUSCANDO SI EXISTEN ELEMENTOS.*/
            return "redirect:/dishManager";
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
