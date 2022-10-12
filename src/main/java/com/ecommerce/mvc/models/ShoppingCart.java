package com.ecommerce.mvc.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "shoppingCart")
    @JsonBackReference
    private List<CustomerOrder> customerOrder;

    @OneToOne
    @JoinColumn(name = "customer_id" , referencedColumnName = "id")
    @JsonIgnore
    private Customer customer;

    @OneToMany(mappedBy = "shoppingCart")
    @JsonManagedReference
    private List<Items> items= new ArrayList<>();

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

    public void addItems(Items item) {
        items.add(item);
    }

    public List<CustomerOrder> getCustomerOrder() {
        return customerOrder;
    }

    public void setOrder(List<CustomerOrder> order) {
        this.customerOrder = customerOrder;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    public int calculateTotalCost(){
        return items.stream().mapToInt(Items::getPrice).sum();
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "items=" + items +
                '}';
    }


}
