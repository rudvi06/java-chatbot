package com.ecommerce.mvc.controllers;

import com.ecommerce.mvc.models.Credentials;
import com.ecommerce.mvc.models.Customer;
import com.ecommerce.mvc.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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

    @GetMapping("/signup")
    public String signup(){
       return "login";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute("credentials") Credentials credentials, BindingResult result, Customer customer){
        if (result.hasErrors()) {
            return "home";
        }
        customer.setEmailId(credentials.getUsername());
        customer.setPassword(credentials.getPassword());
        customerService.saveAndFlush(customer);
        return "home";
    }

    @PostMapping("/loginProcess")
    public String login(@ModelAttribute("credentials") Credentials credentials, BindingResult result){
        if (result.hasErrors()) {
            return "home";
        }
        Customer customer = customerService.findByEmailId(credentials.getUsername());
        if(credentials.getPassword() == customer.getPassword())
            System.out.println("Login successful");
        return "home";
    }
}
