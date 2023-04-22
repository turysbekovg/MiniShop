package com.example.transactions.dto.response;

import com.example.transactions.module.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailDtoResponse { // what we will show to a client about his order and products that he bought

    private Long id;

    private ProductDtoResponse product;

    private Double price;

    private Integer quantity;
}
