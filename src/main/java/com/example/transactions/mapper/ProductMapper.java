package com.example.transactions.mapper;

import com.example.transactions.dto.response.ProductDtoResponse;
import com.example.transactions.module.Product;

public class ProductMapper {

    public static ProductDtoResponse productToDto(Product product){
        ProductDtoResponse productDtoResponse = new ProductDtoResponse();

        productDtoResponse.setId(product.getId());
        productDtoResponse.setTitle(product.getTitle());
        productDtoResponse.setPrice(product.getPrice());
        productDtoResponse.setQuantity(product.getQuantity());

        return productDtoResponse;
    }
}
