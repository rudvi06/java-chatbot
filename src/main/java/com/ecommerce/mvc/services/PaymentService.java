package com.ecommerce.mvc.services;

import com.ecommerce.mvc.models.Customer;
import com.ecommerce.mvc.models.Payment;

import java.util.List;

public interface PaymentService {
    Payment createPayment(Customer customer, int amount);

    List<Payment> getOrder();

    void deletePayment();
}
