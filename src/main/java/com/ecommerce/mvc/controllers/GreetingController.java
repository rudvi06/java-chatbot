package com.ecommerce.mvc.controllers;

import com.ecommerce.mvc.models.Credentials;
import com.ecommerce.mvc.models.Customer;
import com.ecommerce.mvc.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GreetingController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/loginProcess")
    public String login(){
        return "login";
    }

    @PostMapping("/loginProcess")
    public String login(@ModelAttribute("credentials") Credentials credentials){
        Customer customer = customerService.findByEmailId(credentials.getUsername());
        if(credentials.getPassword() == customer.getPassword())
            System.out.println("Login successful");
        return "home";
    }
}
