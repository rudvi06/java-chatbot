package com.ecommerce.mvc.services;

import com.ecommerce.mvc.models.CreditCard;

import java.util.List;
import java.util.Map;

public interface CreditCardService {


    List<CreditCard> findAll();

    CreditCard saveAndFlush(Map<String,Object> jsonObj);

    void deleteAll();
}
