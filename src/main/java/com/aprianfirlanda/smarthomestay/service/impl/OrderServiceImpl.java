package com.aprianfirlanda.smarthomestay.service.impl;

import com.aprianfirlanda.smarthomestay.entity.Order;
import com.aprianfirlanda.smarthomestay.repository.OrderRepository;
import com.aprianfirlanda.smarthomestay.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> findOrdersByEmail(String email) {
        return orderRepository.findOrdersByEmail(email);
    }
}
