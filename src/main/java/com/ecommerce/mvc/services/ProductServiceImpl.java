package com.ecommerce.mvc.services;

import com.ecommerce.mvc.models.Product;
import com.ecommerce.mvc.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    @Transactional
    public Product saveAndFlush(Product product) {
        return productRepository.saveAndFlush(product);
    }

    @Override
    @Transactional
    public List<Product> sortByAscOrder() {
        return productRepository.findAll(Sort.by(Sort.Direction.ASC,"price"));
    }

    @Override
    @Transactional
    public List<Product> saveAllAndFlush(List<Product> products) {
        return productRepository.saveAllAndFlush(products);
    }
}
