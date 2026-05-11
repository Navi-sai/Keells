package com.KeellsSmartGrocery.KeellsSmartGrocery.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import com.KeellsSmartGrocery.KeellsSmartGrocery.dto.ApiResponse;
import com.KeellsSmartGrocery.KeellsSmartGrocery.dto.AvailableQuantityDTO;
import com.KeellsSmartGrocery.KeellsSmartGrocery.dto.ProductDTO;
import com.KeellsSmartGrocery.KeellsSmartGrocery.dto.UpdateQuantityDTO;
import com.KeellsSmartGrocery.KeellsSmartGrocery.entity.Product;
import com.KeellsSmartGrocery.KeellsSmartGrocery.exception.ResourceNotFoundException;
import com.KeellsSmartGrocery.KeellsSmartGrocery.mapper.ProductMapper;
import com.KeellsSmartGrocery.KeellsSmartGrocery.repository.ProductRepository;

@Service
public class InventoryService {
	
		private final ProductRepository productRepository;
		
		public InventoryService(ProductRepository productRepository) {
			this.productRepository = productRepository;
		}
		

		public ProductDTO addProduct(ProductDTO productDto) {
				Product product = ProductMapper.convertToEntity(productDto);
				Product addedProduct = productRepository.save(product);
				
				ProductDTO addedProductDto = ProductMapper.convertToDTO(addedProduct);
				return addedProductDto;	
		}
		
		public List<ProductDTO> getAllProducts(){
			List<Product> allProducts = productRepository.findAll();
			List<ProductDTO> allProductsDto = ProductMapper.converttoDTOs(allProducts);
			return allProductsDto;
		}
		
		public ProductDTO getProductById(Long id) {
			Optional<Product> optionalProduct = productRepository.findById(id);
			if (optionalProduct.isPresent()) {
				Product product = optionalProduct.get();
				return ProductMapper.convertToDTO(product);
			} else {
				
				throw new ResourceNotFoundException("Product not found for id: " + id);
			}
		}
		
		
		public ProductDTO updateQuantity(UpdateQuantityDTO updateQuantityDto) {
			Optional<Product> product = productRepository.findById(updateQuantityDto.getId());
			if(product.isPresent()) {
				Product getProduct = product.get();
				getProduct.setQuantity(updateQuantityDto.getQuantity());
				Product quantityUpdatedProduct = productRepository.save(getProduct);
				return ProductMapper.convertToDTO(quantityUpdatedProduct);
			} else {
				throw new ResourceNotFoundException("Product not found for updating the quantity " + updateQuantityDto.getId());
			}
		}

		
		public ApiResponse deleteProduct(Long id) {
			productRepository.deleteById(id);
			ApiResponse response = new ApiResponse("The product is deleted");
			return response;
		}
		
		public ProductDTO getProductByName(String name) {
			Optional<Product> product = productRepository.findByName(name);
				if (product.isPresent()) {
					Product availableProduct = product.get();
					return ProductMapper.convertToDTO(availableProduct);
				} else {
					throw new ResourceNotFoundException("Product not available in the inventory : " + name);
				}
		}
		
		
		public AvailableQuantityDTO availableQuantity(Long id, String name) {
			Optional<Product> product = productRepository.findByIdAndName(id,name);
			if (product.isPresent()) {
				AvailableQuantityDTO availableQuantity = new AvailableQuantityDTO(product.get().getId(), product.get().getName(), product.get().getQuantity());
				return availableQuantity;
			} else {
				throw new ResourceNotFoundException("Product name not found in inventoory");
			}
		}
		
	

}
