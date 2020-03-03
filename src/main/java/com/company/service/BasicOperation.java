package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.controller.CustomerNotFoundException;
import com.company.domain.Customer;
import com.company.repository.CustomerRepository;

@Service
public class BasicOperation {

	@Autowired
	public CustomerRepository customerRepository;

	public BasicOperation() {}
	
	public BasicOperation(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}
	
	public Customer getCustomerById(Long id) {
		return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
	}

	public Customer save(Customer customer){
		return customerRepository.save(customer);
	}
}
