package com.example.transactions.repository;

import com.example.transactions.module.Product;
import com.example.transactions.module.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
