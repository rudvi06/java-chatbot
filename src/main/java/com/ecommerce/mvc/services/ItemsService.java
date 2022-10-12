package com.ecommerce.mvc.services;

import com.ecommerce.mvc.models.Items;

import java.util.List;
import java.util.Map;

public interface ItemsService {
    Items addItem(Map<String,Integer> jsonObj);

    List<Items> findAll();
}
