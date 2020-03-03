package com.company.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.domain.Order;
import com.company.repository.OrderRepository;

@CrossOrigin(origins = "*")
@RestController
public class OrderController {
	
	private OrderRepository orderRepository;

	OrderController(OrderRepository orderRepository){
		this.orderRepository = orderRepository;
	}
	
	@GetMapping(value="/order/{id}")
	Order GetAnOrderById(@PathVariable Long id) {
		return orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
	}
	
	@GetMapping(value="/order/normal/{id}")
	Order GetAnOrderByIdNormal(@PathVariable Long id) {
		return orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
	}
	
	@PostMapping(value="/order")
	Order addAnOrder(@RequestBody Order order) {
		return orderRepository.save(order);
	}
	
}
