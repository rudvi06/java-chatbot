package com.ecommerce.mvc.controllers;

import com.ecommerce.mvc.models.CreditCard;
import com.ecommerce.mvc.services.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class CreditCardController {

    @Autowired
    private CreditCardService creditCardService;

    @GetMapping("/cardDetails")
    public List<CreditCard> getCreditCards(){
        List<CreditCard> creditCards= creditCardService.findAll();
        return creditCards;
    }

    @PostMapping("/addCardDetails")
    public CreditCard addCreditCards(@RequestBody Map<String,Object> jsonObj){
        return creditCardService.saveAndFlush(jsonObj);
    }

    @GetMapping("/delete")
    public void delete(){
        creditCardService.deleteAll();
    }
}
