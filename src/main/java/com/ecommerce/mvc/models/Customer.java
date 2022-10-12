package com.ecommerce.mvc.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String emailId;

    private String password;
    private String contactNo;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonManagedReference
    private CreditCard creditCard;

    @OneToMany(mappedBy = "customer")
    private List<CustomerAddress> customerAddress;

    @OneToOne(mappedBy = "customer" , cascade = CascadeType.ALL)
    @JsonIgnore
    private ShoppingCart shoppingCart;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<CustomerOrder> customerOrder;

    public List<CustomerAddress> getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(List<CustomerAddress> customerAddress) {
        this.customerAddress = customerAddress;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Customer(){}
    public Customer( String name, String emailId, String contactNo, String password) {
        this.name = name;
        this.emailId = emailId;
        this.contactNo = contactNo;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public List<CustomerOrder> getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(List<CustomerOrder> customerOrder) {
        this.customerOrder = customerOrder;
    }
    /*
    public void addPaymentMethods(String paymentName, PaymentMethod paymentMethod){
        paymentMethods.put(paymentName,paymentMethod);}

    public Optional<CustomerOrder> checkOut(ShoppingCart shoppingCart, String paymentName){
        Optional<PaymentMethod> paymentMethod = Optional.ofNullable(paymentMethods.get(paymentName));
        Optional<Payment> payment = paymentMethod.flatMap(pm->pm.makePayment(shoppingCart.getTotalCost()));
        return payment.map(value -> new CustomerOrder(this, shoppingCart, value));
    }
     */

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", emailId='" + emailId + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", creditCard=" + creditCard +
                '}';
    }
}
