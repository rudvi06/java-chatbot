package com.ecommerce.mvc.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Customer customer;
    @OneToOne(mappedBy = "customerOrder", cascade = CascadeType.ALL)
    private Payment payment;
    @ManyToOne
    @JsonManagedReference
    private ShoppingCart shoppingCart;

    public CustomerOrder(){}

    public CustomerOrder(Customer customer, ShoppingCart shoppingCart, Payment payment) {
        this.customer = customer;
        this.shoppingCart = shoppingCart;
        this.payment = payment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }


    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public String toString() {
        return "CustomerOrder{" +
                "customer=" + customer +
                ", shoppingCart=" + shoppingCart +
                ", payment=" + payment +
                '}';
    }
}
