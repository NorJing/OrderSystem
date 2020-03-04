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

	@Column(name = "date_service_carry_on")
    private Date dateServiceCarryOn;

	@Column(name = "text")
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
    	this.dateServiceCarryOn = new Date();
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

	public Date getDateServiceCarryOn() {
		return dateServiceCarryOn;
	}

	public void setDateServiceCarryOn(Date dateServiceCarryOn) {
		this.dateServiceCarryOn = dateServiceCarryOn;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}