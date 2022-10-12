package com.ecommerce.mvc.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Payment {

    @Id
    private UUID identifier;

    @ManyToOne
    private CreditCard creditCard;
    private int amount;

    @OneToOne
    @JsonIgnore
    private CustomerOrder customerOrder;


    public UUID getIdentifier() {
        return identifier;
    }

    public void setIdentifier(UUID identifier) {
        this.identifier = identifier;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }

    public Payment(){}

    public Payment(CreditCard creditCard, int amount, UUID randomUUID) {
        this.creditCard = creditCard;
        this.amount=amount;
        this.identifier=randomUUID;
    }
}
