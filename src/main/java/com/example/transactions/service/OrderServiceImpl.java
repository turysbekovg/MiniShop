package com.example.transactions.service;

import com.example.transactions.dto.request.OrderDtoRequest;
import com.example.transactions.module.Order;
import com.example.transactions.module.User;
import com.example.transactions.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    private final UserService userService;

    private final OrderDetailService orderDetailService;

    private Order save(Order order){
        return orderRepository.save(order);
    }


    // to find order by id
    @Override
    public Optional<Order> getById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order getByIdThrowException(Long id) {
        return this.getById(id).orElseThrow(() -> new RuntimeException("Cant find such Order"));
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Transactional // this annotation makes if exception -> rolls back
    @Override
    // creating an order
    public void create(List<OrderDtoRequest> dtoRequestList, String address, Principal principal) {
        Order order = new Order();

        try {
            String username = principal.getName();

            User user = userService.getByUsernameThrowException(username);

            order.setUser(user);

            order.setAddress(address);

            Order createdOrder = this.save(order); // saving the order;

            orderDetailService.create(dtoRequestList, createdOrder);  // creating order_and_products

        } catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("Error occurred when creating an order.");
        }
    }
}
