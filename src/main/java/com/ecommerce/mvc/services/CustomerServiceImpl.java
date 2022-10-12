package com.ecommerce.mvc.services;

import com.ecommerce.mvc.models.Customer;
import com.ecommerce.mvc.models.ShoppingCart;
import com.ecommerce.mvc.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    @Transactional
    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }

    @Override
    @Transactional
    public Customer saveAndFlush(Customer customer) {
        ShoppingCart shoppingCart = new ShoppingCart();
        customer.setShoppingCart(shoppingCart);
        shoppingCart.setCustomer(customer);
        customerRepository.saveAndFlush(customer);
        return customer;
    }

    @Override
    @Transactional
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    @Transactional
    public Customer findByName(String name){
        return customerRepository.findByName(name);
    }

    @Override
    @Transactional
    public Customer findByEmailId(String emailId) {
        return customerRepository.findByEmailId(emailId);
    }


}
