package com.ecommerce.mvc.services;

import com.ecommerce.mvc.models.CreditCard;
import com.ecommerce.mvc.models.Customer;
import com.ecommerce.mvc.repositories.CreditCardRepository;
import com.ecommerce.mvc.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    @Transactional
    public List<CreditCard> findAll() {
        return creditCardRepository.findAll();
    }

    @Override
    @Transactional
    public CreditCard saveAndFlush(Map<String,Object> jsonObj) {
        Customer customer= customerRepository.findById((int)jsonObj.get("customerId")).get();
        CreditCard creditCard = new CreditCard((String) jsonObj.get("cardNumber"),customer);
        customer.setCreditCard(creditCard);
        customerRepository.saveAndFlush(customer);
        return creditCard;
    }

    @Override
    @Transactional
    public void deleteAll() {
        creditCardRepository.deleteAll();
    }
}
