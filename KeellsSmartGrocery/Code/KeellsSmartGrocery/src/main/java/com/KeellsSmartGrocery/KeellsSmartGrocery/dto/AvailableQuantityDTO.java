package com.KeellsSmartGrocery.KeellsSmartGrocery.dto;

public class AvailableQuantityDTO {
		
		private Long productId;
		private String productName;
		private int quantity;
		
		public AvailableQuantityDTO() {
			
		}
		
		public AvailableQuantityDTO(Long productId, String productName, int quantity) {
			this.productId = productId;
			this.productName = productName;
			this.quantity = quantity;
		}

		public void setProductId(Long productId) {
			this.productId = productId;
		}
		
		public Long getProductId() {
			return this.productId;
		}
		
		public void setProductName(String productName) {
			this.productName = productName;
		}
		
		public String getProductName() {
			return this.productName;
		}
		
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		
		public int getQuantity() {
			return this.quantity;
		}
	}
