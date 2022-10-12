package com.ecommerce.mvc.services;

import com.ecommerce.mvc.models.CustomerOrder;

import java.util.List;
import java.util.Map;

public interface OrderService {

    CustomerOrder createOrder(Map<String,Integer> jsonObj);

    List<CustomerOrder> getOrder();

    void deleteOrders();
}
