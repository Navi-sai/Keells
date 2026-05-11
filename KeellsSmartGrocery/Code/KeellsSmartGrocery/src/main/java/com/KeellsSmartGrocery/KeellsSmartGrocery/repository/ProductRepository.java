package com.KeellsSmartGrocery.KeellsSmartGrocery.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.KeellsSmartGrocery.KeellsSmartGrocery.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {
	
	public Optional<Product> findByName(String name);
	
	public Optional<Product> findByIdAndName(Long id, String name);
	
	     

}
