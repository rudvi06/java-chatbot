package com.ecommerce.mvc.services;

import com.ecommerce.mvc.models.*;
import com.ecommerce.mvc.repositories.CustomerRepository;
import com.ecommerce.mvc.repositories.OrderRepository;
import com.ecommerce.mvc.repositories.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    @Autowired
    private PaymentService paymentService;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    @Transactional
    public CustomerOrder createOrder(Map<String,Integer> jsonObj) {
        ShoppingCart shoppingCart = shoppingCartRepository.findById(jsonObj.get("shoppingCartId")).get();
        Customer customer = shoppingCart.getCustomer();
        Payment payment=paymentService.createPayment(customer,shoppingCart.calculateTotalCost());
        CustomerOrder customerOrder =new CustomerOrder(customer,shoppingCart,payment);
        payment.setCustomerOrder(customerOrder);
        orderRepository.saveAndFlush(customerOrder);
        return customerOrder;
    }

    @Override
    @Transactional
    public List<CustomerOrder> getOrder() {
        return orderRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteOrders(){
        orderRepository.deleteAll();
    }
}
