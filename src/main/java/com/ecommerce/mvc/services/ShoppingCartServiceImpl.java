package com.ecommerce.mvc.services;

import com.ecommerce.mvc.models.Customer;
import com.ecommerce.mvc.models.ShoppingCart;
import com.ecommerce.mvc.repositories.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Override
    @Transactional
    public ShoppingCart saveAndFlush(Customer customer) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setCustomer(customer);
        shoppingCartRepository.saveAndFlush(shoppingCart);
        return shoppingCart;
    }

    @Override
    public List<ShoppingCart> findAll() {
        return shoppingCartRepository.findAll();
    }
}
