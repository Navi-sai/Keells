package com.KeellsOrder.KeellsOrder.dto;

import java.util.List;

public class OrderRequestDTO {

		private String orderedBy;
		private List<ItemsRequestDTO> itemsRequestDto;
		

		public OrderRequestDTO() {
		}
		
		public OrderRequestDTO(String orderedBy, List<ItemsRequestDTO> itemsRequestDto) {
			this.orderedBy = orderedBy;
			this.itemsRequestDto = itemsRequestDto;
		}

		public String getOrderedBy() {
			return orderedBy;
		}

		public void setOrderedBy(String orderedBy) {
			this.orderedBy = orderedBy;
		}

		public List<ItemsRequestDTO> getItemsRequestDto() {
			return itemsRequestDto;
		}

		public void setItemsRequestDto(List<ItemsRequestDTO> itemsRequestDto) {
			this.itemsRequestDto = itemsRequestDto;
		}
		
		

	}
