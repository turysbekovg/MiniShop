package com.example.transactions.service;

import com.example.transactions.module.Product;
import com.example.transactions.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    private Product save(Product product){
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product getByIdThrowException(Long id) {
        return this.getById(id).orElseThrow(() -> new RuntimeException("No such product."));
    }


    // implementation of updateQuantity
    @Transactional
    @Override
    public void updateQuantity(Long id, Integer quantity) {

        // firstly finding product by its id
        Product product = this.getByIdThrowException(id);

        try{
            // updating quantity
            product.setQuantity(quantity);

            // saving product
            this.save(product);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("Error occurred when trying to update quantity.");
        }

    }
}
