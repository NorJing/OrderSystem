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

    @Column(name = "type")
    private String type; // moving, buy, cleaning etc.. see db query

    @OneToMany(mappedBy = "service")
    private Set<Order> orders;

    public Service(){}

    public Service(Long id) {
        this.id = id;
    }

    public Service(Long id, String type) {
        this.id = id;
        this.type = type;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

