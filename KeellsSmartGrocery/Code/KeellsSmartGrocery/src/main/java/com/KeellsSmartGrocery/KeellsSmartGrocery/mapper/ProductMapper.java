package com.KeellsSmartGrocery.KeellsSmartGrocery.mapper;

import java.util.ArrayList;
import java.util.List;

import com.KeellsSmartGrocery.KeellsSmartGrocery.dto.ProductDTO;
import com.KeellsSmartGrocery.KeellsSmartGrocery.entity.Product;

public class ProductMapper {
	
	
	//DTO-ENTITY
	
	public static Product convertToEntity(ProductDTO productDto) {
		Product product = new Product(
								productDto.getName(), 
								productDto.getPrice(), 
								productDto.getQuantity());
		return product;
	}
	
	//ENTITY - DTO
	
	public static ProductDTO convertToDTO(Product product) {
		ProductDTO productDto = new ProductDTO(
								product.getId(),
								product.getName(), 
								product.getPrice(), 
								product.getQuantity());
		return productDto;
	}
	
	public static List<ProductDTO> converttoDTOs(List<Product> products){
				List<ProductDTO> prd = new ArrayList<>();
				for(Product product : products) {
					ProductDTO prdDto = convertToDTO(product);
					prd.add(prdDto);
				}
				
				return prd;
	}
	
	

}
