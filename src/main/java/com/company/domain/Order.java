package com.company.domain;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name="order_table")
public class Order {

	@Id
	@Column(name = "id")
    private Long id;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "service_id")
	private Service service;

	/*@OneToOne
	@JoinColumn(name = "services_id")
	private Services services;*/

	@Column(name = "order_time")
    private Date orderTime;

	@Column(name = "note")
    private String note;
    
    Order(){}

	public Order(Long id){
    	this.id = id;
	}

	public Order(Long id, Customer customer, Service services, String note) {
		this.id = id;
		this.customer = customer;
		this.service = services;
		this.note = note;
	}

	@PrePersist
	void serviceCarryOnDate() {
    	this.orderTime = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Service getServices() {
		return service;
	}

	public void setServices(Service service) {
		this.service = service;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}