package com.losAmos.demoLosAmos.controllers;

import com.losAmos.demoLosAmos.models.impl.CartServiceImpl;
import com.losAmos.demoLosAmos.models.services.GenericServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {

    @Autowired
    private CartServiceImpl cartAPI;


    /**
     * Routing Cart.
     * @param model
     * @return
     */
    @GetMapping( value = {"/user/cart"} )
    public String getCart(Model model) {
        model.addAttribute("title", "Carrito");
        model.addAttribute("cart", cartAPI.getAll());
        return "cart";
    }

    @GetMapping( value = {"/admin/cart"} )
    public String getAdminCart(Model model) {
        model.addAttribute("title", "Carrito");
        model.addAttribute("cart", cartAPI.getAll());
        return "cart";
    }

    @GetMapping("/user/order_history")
    public String getOrderHistory(Model model){
        model.addAttribute("title", "Historial de Pedidos");
        model.addAttribute("cart", cartAPI.getAll());
        return "order_history";
    }

    @GetMapping("/admin/order_history")
    public String getAdminHistory(Model model){
        model.addAttribute("title", "Historial de Ventas");
        model.addAttribute("cart", cartAPI.getAll());
        return "order_history";
    }
}
