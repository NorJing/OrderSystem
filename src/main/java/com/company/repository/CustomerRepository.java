package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByName(String name);
    
    //Optional<User> findById(Long id);
    
    // findByNameBetweenDate

}