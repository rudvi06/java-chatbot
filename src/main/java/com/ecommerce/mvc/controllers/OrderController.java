package com.ecommerce.mvc.controllers;

import com.ecommerce.mvc.models.CustomerOrder;
import com.ecommerce.mvc.models.Payment;
import com.ecommerce.mvc.services.OrderService;
import com.ecommerce.mvc.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/order")
    public CustomerOrder createOrder(@RequestBody Map<String,Integer> jsonObj){
        return orderService.createOrder(jsonObj);
    }

    @GetMapping("/order")
    public List<CustomerOrder> getOrder(){
        return orderService.getOrder();
    }

    @GetMapping("/payment")
    public List<Payment> getPayments(){
        return paymentService.getOrder();
    }

    @GetMapping("/deleteOrder")
    public void deleteOrder(){
        orderService.deleteOrders();
    }

    @GetMapping("/deletePayment")
    public void deletePayment(){
        paymentService.deletePayment();
    }
}
