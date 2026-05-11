package com.KeellsOrder.KeellsOrder.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.KeellsOrder.KeellsOrder.dto.OrderRequestDTO;
import com.KeellsOrder.KeellsOrder.service.OrderService;

@RestController
@RequestMapping("/orderService")
public class OrderController {
	
	private final OrderService orderService;
	
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	
    // CREATE ORDER API
    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestBody OrderRequestDTO orderRequestDTO) {

        orderService.createOrder(orderRequestDTO);

        return ResponseEntity.ok("Order created successfully");
    }

}
