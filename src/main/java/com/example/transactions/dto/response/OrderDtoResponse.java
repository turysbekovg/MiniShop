package com.example.transactions.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class OrderDtoResponse { // what we will return to a client

    private Long id;

    private UserDtoResponse user;

    private String address;

    private LocalDateTime createdDateTime;

    private List<OrderDetailDtoResponse> orderDetailList;
}
