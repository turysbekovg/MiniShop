package com.example.transactions.mapper;

import com.example.transactions.dto.response.OrderDtoResponse;
import com.example.transactions.module.Order;
import com.example.transactions.module.OrderDetail;

import java.util.stream.Collectors;

public class OrderMapper {

    public static OrderDtoResponse orderToDto(Order order){
        OrderDtoResponse orderDtoResponse = new OrderDtoResponse();

        orderDtoResponse.setId(order.getId());
        orderDtoResponse.setUser(UserMapper.userToDto(order.getUser()));
        orderDtoResponse.setAddress(order.getAddress());
        orderDtoResponse.setCreatedDateTime(order.getCreatedDateTime());
        orderDtoResponse.setOrderDetailList(order.getOrderDetailList().stream().map(OrderDetailMapper::orderDetailToDto).collect(Collectors.toList()));

        return orderDtoResponse;
    }
}
