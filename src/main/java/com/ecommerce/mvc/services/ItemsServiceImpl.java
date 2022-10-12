package com.ecommerce.mvc.services;

import com.ecommerce.mvc.models.Items;
import com.ecommerce.mvc.models.Product;
import com.ecommerce.mvc.models.ShoppingCart;
import com.ecommerce.mvc.repositories.ItemRepository;
import com.ecommerce.mvc.repositories.ProductRepository;
import com.ecommerce.mvc.repositories.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
public class ItemsServiceImpl implements ItemsService{

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional
    public Items addItem(Map<String, Integer> jsonObj) {
        ShoppingCart shoppingCart = shoppingCartRepository.findById(jsonObj.get("shoppingCartId")).get();
        Product product = productRepository.findById(jsonObj.get("productId")).get();
        Items items= new Items(product,jsonObj.get("quantity"));
        items.setShoppingCart(shoppingCart);
        itemRepository.saveAndFlush(items);
        return items;
    }

    @Override
    @Transactional
    public List<Items> findAll() {
        return itemRepository.findAll();
    }
}
