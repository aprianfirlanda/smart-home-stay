package com.aprianfirlanda.smarthomestay.controller;

import com.aprianfirlanda.smarthomestay.dto.OrderDto;
import com.aprianfirlanda.smarthomestay.dto.ResponseDto;
import com.aprianfirlanda.smarthomestay.entity.Order;
import com.aprianfirlanda.smarthomestay.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<ResponseDto.Base> findFacilitiesByType(@RequestBody OrderDto.Create request) {
        orderService.save(request);

        ResponseDto.Base response = new ResponseDto.Base();
        response.setStatus("Success");
        response.setMessage("Successfully order");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/by-email")
    public ResponseEntity<ResponseDto.WithData<List<Order>>> findFacilitiesByType(@RequestBody OrderDto.Find request) {
        ResponseDto.WithData<List<Order>> response = new ResponseDto.WithData<>();
        response.setStatus("Success");
        response.setMessage("Successfully get orders by email");
        response.setData(orderService.findOrdersByEmail(request.getEmail()));

        return ResponseEntity.ok(response);
    }
}