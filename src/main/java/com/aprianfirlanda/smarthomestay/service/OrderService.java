package com.aprianfirlanda.smarthomestay.service;

import com.aprianfirlanda.smarthomestay.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> findOrdersByEmail(String email);
}
