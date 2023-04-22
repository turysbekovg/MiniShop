package com.example.transactions.service;

import com.example.transactions.dto.request.OrderDtoRequest;
import com.example.transactions.module.Order;
import com.example.transactions.module.OrderDetail;
import com.example.transactions.module.Product;
import com.example.transactions.repository.OrderDetailRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class OrderDetailServiceImpl implements OrderDetailService{

    private final OrderDetailRepository orderDetailRepository;

    private final ProductService productService;

    private OrderDetail save(OrderDetail orderDetail){
        return orderDetailRepository.save(orderDetail);
    }

    @Transactional
    // this method is to create Order_product (to give the info about what product and order)
    @Override
    public void create(List<OrderDtoRequest> dtoRequestList, Order order) {
        for(OrderDtoRequest dtoRequest : dtoRequestList){

            try{
                OrderDetail orderDetail = new OrderDetail(); // creating new order_product

                // finding product by id
                Product product = productService.getByIdThrowException(dtoRequest.getProductId());

                //setting details (order, product, quantity, price)
                orderDetail.setOrder(order);
                orderDetail.setProduct(product);
                orderDetail.setQuantity(dtoRequest.getQuantity());
                orderDetail.setPrice(product.getPrice());

                //saving product
                this.save(orderDetail);

                // updating quantity of a product
                productService.updateQuantity(product.getId(), product.getQuantity() - dtoRequest.getQuantity());
            } catch (Exception e){
                log.error(e.getMessage());
                throw new RuntimeException("Some error occurred.");
            }
        }
    }
}
