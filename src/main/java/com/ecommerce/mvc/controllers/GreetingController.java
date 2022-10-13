package com.ecommerce.mvc.controllers;

import com.ecommerce.mvc.models.Credentials;
import com.ecommerce.mvc.models.Customer;
import com.ecommerce.mvc.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("credentials", new Credentials());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("credentials") Credentials credentials, BindingResult result){
        if (result.hasErrors()) {
            return "error";
        }
        Customer customer = customerService.findByEmailId(credentials.getUsername());
        if(credentials.getPassword() == customer.getPassword())
            System.out.println("Login successful");
        return "home";
    }

    @GetMapping("/signup")
    public String signup(Model model){
        model.addAttribute("credentials", new Credentials());
        return "signup";
    }

    @PostMapping("/signup")
    public String signup( @ModelAttribute("credentials") Credentials credentials, BindingResult result, Customer customer){
        if (result.hasErrors()) {
            return "error";
        }
        customer.setEmailId(credentials.getUsername());
        customer.setPassword(credentials.getPassword());
        customerService.saveAndFlush(customer);
        return "home";
    }

}
