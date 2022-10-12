package com.ecommerce.mvc.controllers;

import com.ecommerce.mvc.models.Credentials;
import com.ecommerce.mvc.models.Customer;
import com.ecommerce.mvc.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /*
    @PostMapping("/loginProcess")
    public String login(@ModelAttribute("credentials") Credentials credentials){
        Customer customer = customerService.findByEmailId(credentials.getUsername());
        if(credentials.getPassword() == customer.getPassword())
            System.out.println("Login successful");
        return "home";
    }

    @GetMapping("/login")
    public void getCustomer(@RequestParam(value = "emailId" ) String emailId,
                                @RequestParam(value = "password" ) String password){
        Customer customer = customerService.findByEmailId(emailId);
        if( password == customer.getPassword())
           System.out.println("Login successful");

    }*/

    @GetMapping("/accounts")
    public List<Customer> getCustomers(){
        List<Customer> customers= customerService.findAll();
        return customers;
    }

    @PostMapping("/register")
    public Customer addCustomer(@RequestBody Customer customer){
        customerService.saveAndFlush(customer);
        return customer;
    }

}
