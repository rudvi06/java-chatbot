package com.ecommerce.mvc.services;

import com.ecommerce.mvc.models.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product saveAndFlush(Product product);

    List<Product> sortByAscOrder();

    List<Product> saveAllAndFlush(List<Product> products);
}
