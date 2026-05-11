package com.KeellsOrder.KeellsOrder.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderNo;
	private String orderBy;
	private LocalDateTime orderDate;
	private double billAmount;
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<Items> items;
	
	public Orders() {
	}

	public Orders(Long orderNo, String orderBy, LocalDateTime orderDate, double billAmount, List<Items> items) {
		super();
		this.orderNo = orderNo;
		this.orderBy = orderBy;
		this.orderDate = orderDate;
		this.billAmount = billAmount;
		this.items = items;
	}

	public Long getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}
	

}
