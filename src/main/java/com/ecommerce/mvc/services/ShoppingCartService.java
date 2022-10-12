package com.ecommerce.mvc.services;

import com.ecommerce.mvc.models.Customer;
import com.ecommerce.mvc.models.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {

    ShoppingCart saveAndFlush(Customer customer);

    List<ShoppingCart> findAll();
}
