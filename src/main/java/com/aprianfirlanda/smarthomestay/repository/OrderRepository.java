package com.aprianfirlanda.smarthomestay.repository;

import com.aprianfirlanda.smarthomestay.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {

    List<Order> findOrdersByEmail(String email);
}
