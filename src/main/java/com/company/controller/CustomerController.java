package com.company.controller;


import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.domain.Order;
import com.company.domain.Customer;
import com.company.repository.OrderRepository;
import com.company.repository.CustomerRepository;
import com.company.service.BasicOperation;

@CrossOrigin(origins = "*")
@RestController
public class CustomerController {
	
	private CustomerRepository customerRepository;
	private OrderRepository orderRepository;
	private BasicOperation basicOperation;
	
	CustomerController(CustomerRepository customerRepository, OrderRepository orderRepository,
					   BasicOperation basicOperation){
		this.customerRepository = customerRepository;
		this.orderRepository = orderRepository;
		this.basicOperation = basicOperation;
	}
	
	@PostMapping(value="/customer")
	Customer addAnCustomer(@RequestBody Customer customer) {
		return basicOperation.save(customer);
	}
	
	@GetMapping(value="/customer/{id}")
	Customer getCustomerById(@PathVariable Long id) {
		return basicOperation.getCustomerById(id);
	}
	
	@GetMapping(value="/customer/{id}/order")
	Set<Order> getOrdersByCustomerId(@PathVariable Long id){
		Customer user = customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
		Set<Order> orders = user.getOrders();
		return orders;
	} 
	
	@GetMapping(value="/username/{name}")
	Customer getAnCustomerByName(@PathVariable String name) {
		return customerRepository.findByName(name);
	}
	
	@GetMapping(value="/customers")
	List<Customer> allCustomers() {
		return basicOperation.getAllCustomers();
	}
	
	/*@PutMapping("/customer/{id}")
	Customer replaceCustomerAndOrder(@RequestBody Customer newUser, @PathVariable Long id) {
		return customerRepository.findById(id)
				.map(user -> {
					user.setName(newUser.getName());
					user.setPhoneNumber(newUser.getPhoneNumber());
					user.setSourceAddress(newUser.getSourceAddress());
					user.setDestinationAddress(newUser.getDestinationAddress());
					
					if (user.getOrders().size() != 0) {
						// if user already has an order
						Set<Order> oldOrder = user.getOrders();
						System.out.println("old order=" + oldOrder);
						user.removeOrder(oldOrder);
					}
					// replace an order if user has order
					// add an order if user does not have order
					Order newOrder = newUser.getOrders().get(0);
					System.out.println("new order=" + newOrder);
					user.addOrder(newOrder);
					return customerRepository.save(user);
				}).orElseGet(() -> {
					newUser.setId(id);
					return customerRepository.save(newUser);
				});
	 }*/
	
	@DeleteMapping("/customer/{id}/order/{orderId}")
	void deleteAnOrderFromACustomer(@PathVariable Long id, @PathVariable Long orderId) {
		/*Customer user = customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
		Order order = orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException(orderId));
		user.removeOrder(order);
		customerRepository.save(user);
		*/

		// return ResponseEntity.noContent().build();
		
		// not work due to constain issue orderRepository.delete(order);
		/*userRepository.findById(id)
			.map(user -> {
				user.removeOrder(order);
				// userRepository.save(user);
		}).orElseThrow(() -> new OrderNotFoundException(id));*/
	}

}
