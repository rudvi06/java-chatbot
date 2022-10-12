package com.ecommerce.mvc.services;

import com.ecommerce.mvc.models.Customer;
import java.util.List;

public interface CustomerService {
    Customer save(Customer customer);
    Customer saveAndFlush(Customer customer);

    List<Customer> findAll();

    Customer findByName(String name);

    Customer findByEmailId(String emailId);
}
