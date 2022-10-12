package com.ecommerce.mvc.controllers;

import com.ecommerce.mvc.models.ShoppingCart;
import com.ecommerce.mvc.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping("/getCart")
    public List<ShoppingCart> getCart(){
        return shoppingCartService.findAll();
    }
}
