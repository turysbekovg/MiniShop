package com.example.transactions.mapper;

import com.example.transactions.dto.response.OrderDetailDtoResponse;
import com.example.transactions.module.OrderDetail;

public class OrderDetailMapper {
    public static OrderDetailDtoResponse orderDetailToDto(OrderDetail orderDetail){

        OrderDetailDtoResponse orderDetailDtoResponse = new OrderDetailDtoResponse();

        orderDetailDtoResponse.setId(orderDetail.getId());
        orderDetailDtoResponse.setProduct(ProductMapper.productToDto(orderDetail.getProduct()));
        orderDetailDtoResponse.setPrice(orderDetail.getPrice());
        orderDetailDtoResponse.setQuantity(orderDetail.getQuantity());

        return orderDetailDtoResponse;
    }
}
