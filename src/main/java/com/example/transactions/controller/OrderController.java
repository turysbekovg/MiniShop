package com.example.transactions.controller;


import com.example.transactions.dto.request.OrderDtoRequest;
import com.example.transactions.dto.response.OrderDtoResponse;
import com.example.transactions.mapper.OrderMapper;
import com.example.transactions.module.Order;
import com.example.transactions.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    // this method is to find an order by ID;
    @GetMapping("/{id}")
    public ResponseEntity<OrderDtoResponse> getById(@PathVariable(name = "id") Long id) {
        Order order = orderService.getByIdThrowException(id); // finding order

        OrderDtoResponse orderDtoResponse = OrderMapper.orderToDto(order);

        return new ResponseEntity<>(orderDtoResponse, HttpStatus.OK); // giving order by id to a client
    }


    // this method is to find all orders
    @GetMapping("/")
    public ResponseEntity<List<OrderDtoResponse>> getAll() {

        List<OrderDtoResponse> dtoResponseList = orderService.getAll().stream().map(OrderMapper::orderToDto)
                .collect(Collectors.toList());

        return new ResponseEntity<>(dtoResponseList, HttpStatus.OK); // giving all orders
    }


    @PostMapping("/create/{address}")
    public ResponseEntity<HttpStatus> create(@RequestBody List<OrderDtoRequest> orderDtoRequestList,
                                             @PathVariable(name="address") String address,
                                             Principal principal){
// Principal - interface, saving info about who entered to the system (who already authorized and makes a request)

        orderService.create(orderDtoRequestList, address, principal);

        return new ResponseEntity<>(HttpStatus.CREATED);

    }



}
