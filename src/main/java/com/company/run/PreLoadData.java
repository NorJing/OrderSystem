package com.company.run;

import com.company.domain.Customer;
import com.company.domain.Order;
import com.company.domain.Service;
import com.company.repository.CustomerRepository;
import com.company.repository.OrderRepository;
import com.company.repository.ServiceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class PreLoadData {

    @Bean
    public CommandLineRunner dataLoader(CustomerRepository customerRepository, OrderRepository orderRepository,
                                        ServiceRepository serviceRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                System.out.println("Pre data loading");

                Customer customer1 = new Customer(1L, "Tom", "95451234",
                        "Askerveien 1", "Sagene gate 1");
                customerRepository.save(customer1);

                Customer customer2 = new Customer(2L, "Tommy", "95451234",
                        "Askerveien 1", "Sagene gate 1");
                customerRepository.save(customer2);

                String type1 = "packing, cleaning";
                Service service1 = new Service(1L, type1);
                serviceRepository.save(service1);

                String type2 = "moving, selling";
                Service service2 = new Service(2L, type2);
                serviceRepository.save(service2);

                Order order = new Order(1L, customer1, service1, "note 1x");
                orderRepository.save(order);

                Order order2 = new Order(2L, customer2, service2, "note 2x");
                orderRepository.save(order2);

                System.out.println("PreDataLoader done");
            }
        };
    }
}
