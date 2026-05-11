package com.KeellsSmartGrocery.KeellsSmartGrocery.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.KeellsSmartGrocery.KeellsSmartGrocery.dto.ApiResponse;
import com.KeellsSmartGrocery.KeellsSmartGrocery.dto.AvailableQuantityDTO;
import com.KeellsSmartGrocery.KeellsSmartGrocery.dto.ProductDTO;
import com.KeellsSmartGrocery.KeellsSmartGrocery.dto.UpdateQuantityDTO;
import com.KeellsSmartGrocery.KeellsSmartGrocery.service.impl.InventoryService;


@RestController
@RequestMapping("/inventoryServices")
public class InventoryController {
	
	private final InventoryService inventoryService;
	
	public InventoryController(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}
	
	
	@PostMapping("/addProduct")
	public ProductDTO addProduct(@RequestBody ProductDTO productDto) {
		return inventoryService.addProduct(productDto);
	}
	
	@GetMapping("/getAllProducts")
	public List<ProductDTO> getAllProducts(){
		return inventoryService.getAllProducts();
	}
	
	@GetMapping("/getProductById")
	public ProductDTO getProductById(@RequestParam Long id) {
		return inventoryService.getProductById(id);
	}
	
	@PutMapping("/updateQuantity")
	public ProductDTO updateQuantity(@RequestBody UpdateQuantityDTO updateQuantityDto) {
		return inventoryService.updateQuantity(updateQuantityDto);
	}
	
	@DeleteMapping("/deleteProduct")
	public ApiResponse deleteProduct(@RequestParam Long id) {
		return inventoryService.deleteProduct(id);
	}
	
	
	@GetMapping("/getProductByName")
	public ProductDTO getProductByName(@RequestParam String name) {
		return inventoryService.getProductByName(name);
	}
 
	@GetMapping("availableQuantity")
	public AvailableQuantityDTO availableQuantity(@RequestParam Long id, @RequestParam String name) {
		return  inventoryService.availableQuantity(id, name);
	}
	

}
