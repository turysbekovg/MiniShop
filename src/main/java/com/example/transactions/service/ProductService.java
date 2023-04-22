package com.example.transactions.service;

import com.example.transactions.module.Product;

import java.util.Optional;

public interface ProductService {

    // this method is to find product
    Optional<Product> getById(Long id);

    Product getByIdThrowException(Long id);

    // this method is to update quantity on stock when a client will buy a product
    void updateQuantity(Long id, Integer quantity);
}
