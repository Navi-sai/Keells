	package com.KeellsSmartGrocery.KeellsSmartGrocery.dto;
	
	public class UpdateQuantityDTO {
		
		private Long id;
		private int quantity;
		
		
		public UpdateQuantityDTO() {
			
		}
		
		public UpdateQuantityDTO(Long id, int quantity) {
			this.id = id;
			this.quantity = quantity;
		}
		
		public void setId(Long id) {
			this.id = id;
		}
		
		public Long getId() {
			return id;
		}
		
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		
		public int getQuantity() {
			return quantity;
		}
	
	}
