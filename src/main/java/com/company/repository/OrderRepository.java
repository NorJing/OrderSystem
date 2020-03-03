package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
