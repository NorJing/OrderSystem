package com.company.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="customer")
public class Customer{
	
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
    
    @NotNull
    @Column(name = "phonenumber")
    private String phoneNumber;
    
    @Size(min=5)
    @Column(name = "sourceaddress")
    private String sourceAddress;

    @Column(name = "destinationaddress")
    private String destinationAddress;

    @OneToMany(mappedBy = "customer")
    private Set<Order> orders;

    /*public void addOrder(Order order) {
        this.orders.add(order);
	}
    
    public void removeOrder(Order order) {
        this.orders.remove(order);
    }*/
    
    Customer() {}

    public Customer(Long id) {
        this.id = id;
    }

    public Customer(Long id, String name, @NotNull String phoneNumber,
                    @Size(min = 8) String sourceAddress, String destinationAddress) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.sourceAddress = sourceAddress;
        this.destinationAddress = destinationAddress;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSourceAddress() {
        return sourceAddress;
    }

    public void setSourceAddress(String sourceAddress) {
        this.sourceAddress = sourceAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", sourceAddress='" + sourceAddress + '\'' +
                ", destinationAddress='" + destinationAddress + '\'' +
                '}';
    }
}
