package com.KeellsOrder.KeellsOrder.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ItemsOrdered")
public class Items {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderedItemsId;
	private Long productId;
	private String productName;
	private int quantity;
	@ManyToOne
	@JoinColumn(name = "order_no")
	private Orders order;
	
	public Items() {
		super();
	}

	public Items(Long orderedItemsId, Long productId, String productName, int quantity, Orders order) {
		this.orderedItemsId = orderedItemsId;
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.order = order;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getOrderedItemsId() {
		return orderedItemsId;
	}

	public void setOrderedItemsId(Long orderedItemsId) {
		this.orderedItemsId = orderedItemsId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}
	
	

}
