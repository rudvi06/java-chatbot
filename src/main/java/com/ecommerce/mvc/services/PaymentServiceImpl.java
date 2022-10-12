package com.ecommerce.mvc.services;

import com.ecommerce.mvc.models.CreditCard;
import com.ecommerce.mvc.models.Customer;
import com.ecommerce.mvc.models.Payment;
import com.ecommerce.mvc.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    @Transactional
    public Payment createPayment(Customer customer, int amount) {
        CreditCard creditCard=customer.getCreditCard();
        Payment payment=new Payment(creditCard,amount, UUID.randomUUID());
        return payment;
    }

    @Override
    @Transactional
    public List<Payment> getOrder() {
        return paymentRepository.findAll();
    }

    @Override
    @Transactional
    public void deletePayment(){
        paymentRepository.deleteAllInBatch();
    }



}
