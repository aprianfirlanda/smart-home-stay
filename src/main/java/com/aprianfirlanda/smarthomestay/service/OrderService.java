package com.aprianfirlanda.smarthomestay.service;

import com.aprianfirlanda.smarthomestay.dto.OrderDto;
import com.aprianfirlanda.smarthomestay.entity.Order;
import com.aprianfirlanda.smarthomestay.error.clienterror.NotFoundError;

import java.util.List;

public interface OrderService {
    List<Order> findOrdersByEmail(String email);

    Long save(OrderDto.Create request);
    void checkIn(Long id) throws NotFoundError;
    void checkOut(Long id) throws NotFoundError;
    void setBill(Long id, List<OrderDto.SetBill> requests) throws NotFoundError;
}
