package com.example.transactions.service;

import com.example.transactions.dto.request.OrderDtoRequest;
import com.example.transactions.module.Order;

import java.util.List;

public interface OrderDetailService {

    // this method is to create Order_product (to give the info about what product and order)
    void create(List<OrderDtoRequest> dtoRequestList, Order order);
}
