package com.ecommerce.mvc.controllers;

import com.ecommerce.mvc.models.Items;
import com.ecommerce.mvc.services.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    @PostMapping("/item")
    private Items addToCart(@RequestBody Map<String, Integer> jsonObj){
        System.out.println(" \n\n\n "+jsonObj);
        return itemsService.addItem(jsonObj);
    }

    @GetMapping("/item")
    private List<Items> getItems(){

        return itemsService.findAll();
    }
}
