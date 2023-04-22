package com.example.transactions.service;

import com.example.transactions.dto.request.OrderDtoRequest;
import com.example.transactions.module.Order;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

public interface OrderService {

    // methods to find order by Id
    Optional<Order> getById(Long id);

    Order getByIdThrowException(Long id);

    List<Order> getAll();

    // this method is to create an order
    void create(List<OrderDtoRequest> dtoRequestList, String address, Principal principal);

}
