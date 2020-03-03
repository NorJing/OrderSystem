package com.company.run;

import com.company.domain.Customer;
import com.company.domain.Order;
import com.company.domain.Service;
import com.company.repository.CustomerRepository;
import com.company.repository.OrderRepository;
import com.company.repository.ServiceRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

                Service service1 = new Service(1L, "moving");
                Service service2 =  new Service(2L, "cleaning");
                Service service3 = new Service(3L, "packing");
                serviceRepository.save(service1);
                serviceRepository.save(service2);
                serviceRepository.save(service3);

                Order order1 = new Order(1L, customer1, service1, "This is order 1");
                Order order2 = new Order(2L, customer1, service2, "This is order 2");
                Order order3 = new Order(3L, customer1, service3, "This is order 3");
                orderRepository.save(order1);
                orderRepository.save(order2);
                orderRepository.save(order3);
                System.out.println("PreDataLoader done");
            }
        };
    }
}
