package com.example.transactions.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDtoResponse {

    private Long id;

    private String title;

    private Double price;

    private Integer quantity;
}
