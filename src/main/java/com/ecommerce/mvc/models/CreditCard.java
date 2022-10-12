package com.ecommerce.mvc.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Optional;
import java.util.UUID;
@Entity
public class CreditCard implements PaymentMethod{
    @Id
    private String cardNumber;
    @OneToOne
    @JoinColumn(name = "customerId",referencedColumnName = "id")
    @JsonBackReference
    private Customer customer;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CreditCard(){}

    public CreditCard(String cardNumber, Customer customer) {
        this.cardNumber = cardNumber;
        this.customer = customer;
    }
    @Override
    public Optional<Payment> makePayment(int value){
        if(Math.random()>0.3)
            return Optional.of(new Payment(this,value, UUID.randomUUID()));
        else
            return Optional.empty();
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "cardNumber=" + cardNumber +
                '}';
    }
}
