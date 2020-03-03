package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.company.domain.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}
