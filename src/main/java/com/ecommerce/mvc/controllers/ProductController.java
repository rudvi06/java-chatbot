package com.ecommerce.mvc.controllers;

import com.ecommerce.mvc.models.Product;
import com.ecommerce.mvc.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> listProducts(){
        return productService.findAll();
    }

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return productService.saveAndFlush(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return productService.saveAllAndFlush(products);
    }

    @GetMapping("/products/asc")
    public List<Product> sortByAscOrder(){
        List<Product> products = productService.sortByAscOrder();
        return products;
    }
}
