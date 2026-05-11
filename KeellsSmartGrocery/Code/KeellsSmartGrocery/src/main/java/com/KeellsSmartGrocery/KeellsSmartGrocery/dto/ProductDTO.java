package com.KeellsSmartGrocery.KeellsSmartGrocery.dto;

public class ProductDTO {
	
	private Long productId;
	private String name;
	private double price;
	private int quantity;
	
	
	public ProductDTO() {
		
	}
	
	public ProductDTO(Long productId, String name, double price,int quantity) {
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	public Long getproductId() {
		return productId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setPrice (double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}
	
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getQuantity() {
		return quantity;
	}
}
