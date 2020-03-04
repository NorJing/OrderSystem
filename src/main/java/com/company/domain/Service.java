package com.company.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "service_table")
public class Service {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "choice")
    private String choice; // moving, buy, cleaning etc.. see db query

    @OneToMany(mappedBy = "service")
    private Set<Order> orders;

    /*@ManyToOne
    private Services services;*/

    public Service(){}

    public Service(Long id) {
        this.id = id;
    }

    public Service(Long id, String choice) {
        this.id = id;
        this.choice = choice;
    }

    /*public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }*/

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }
}

