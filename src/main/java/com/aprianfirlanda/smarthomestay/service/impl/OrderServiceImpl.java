package com.aprianfirlanda.smarthomestay.service.impl;

import com.aprianfirlanda.smarthomestay.dto.OrderDto;
import com.aprianfirlanda.smarthomestay.entity.Facility;
import com.aprianfirlanda.smarthomestay.entity.Order;
import com.aprianfirlanda.smarthomestay.error.clienterror.NotFoundError;
import com.aprianfirlanda.smarthomestay.repository.FacilityRepository;
import com.aprianfirlanda.smarthomestay.repository.OrderRepository;
import com.aprianfirlanda.smarthomestay.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final FacilityRepository facilityRepository;

    public OrderServiceImpl(OrderRepository orderRepository,
                            FacilityRepository facilityRepository) {
        this.orderRepository = orderRepository;
        this.facilityRepository = facilityRepository;
    }

    @Override
    public List<Order> findOrdersByEmail(String email) {
        return orderRepository.findOrdersByEmail(email);
    }

    @Override
    public Long save(OrderDto.Create request) {
        List<Facility> facilities = new ArrayList<>();
        request.getFacilityIds().forEach(id -> {
            Optional<Facility> facility = facilityRepository.findById(id);
            facility.ifPresent(facilities::add);
        });

        Order order = new Order();
        order.setEmail(request.getEmail());
        order.setFacilities(facilities);

        log.info(order.toString());

        orderRepository.save(order);

        return order.getId();
    }

    @Override
    public void checkIn(Long id) throws NotFoundError {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            order.setCheckIn(new Timestamp(System.currentTimeMillis()));

            orderRepository.save(order);
        } else {
            throw new NotFoundError("Order not found");
        }
    }

    @Override
    public void checkOut(Long id) throws NotFoundError {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            order.setCheckOut(new Timestamp(System.currentTimeMillis()));

            orderRepository.save(order);
        } else {
            throw new NotFoundError("Order not found");
        }
    }
}
