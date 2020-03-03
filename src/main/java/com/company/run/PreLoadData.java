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
                customerRepository.save(customer1);
                customerRepository.save(customer2);

                Service service1 = new Service(1L, "moving");
                Service service2 =  new Service(2L, "cleaning");
                Service service3 = new Service(3L, "packing");
                serviceRepository.save(service1);
                serviceRepository.save(service2);
                serviceRepository.save(service3);

                List<Service> servicesList1 = new ArrayList<>();
                servicesList1.add(service1);
                servicesList1.add(service2);
                servicesList1.add(service3);

                int i = 1;
                long j = 1L;
                for(Service service : servicesList1){
                    String note = "This is order " + Integer.toString(i);
                    Order order = new Order(j, customer1, service, note);
                    orderRepository.save(order);
                    i++;
                    j++;
                }

                for(Service service : servicesList1){
                    String note = "This is order " + Integer.toString(i);
                    Order order = new Order(j, customer2, service, note);
                    orderRepository.save(order);
                    i++;
                    j++;
                }

                System.out.println("PreDataLoader done");
            }
        };
    }
}
