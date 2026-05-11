package com.KeellsOrder.KeellsOrder.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.KeellsOrder.KeellsOrder.dto.ItemsRequestDTO;
import com.KeellsOrder.KeellsOrder.dto.OrderRequestDTO;
import com.KeellsOrder.KeellsOrder.dto.ProductResponseDTO;
import com.KeellsOrder.KeellsOrder.entity.Items;
import com.KeellsOrder.KeellsOrder.entity.Orders;
import com.KeellsOrder.KeellsOrder.exception.ExternalServiceException;
import com.KeellsOrder.KeellsOrder.exception.NotAvailableException;
import com.KeellsOrder.KeellsOrder.httpClient.HttpClient;
import com.KeellsOrder.KeellsOrder.repository.OrdersRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderService {
	
	private static final LocalDateTime LocalDateTime = null;
	private final HttpClient httpClient;
	private final OrdersRepository ordersRepository;
	
	public OrderService(HttpClient httpClient, OrdersRepository ordersRepository) {
		this.httpClient = httpClient;
		this.ordersRepository = ordersRepository;
	}
	
	
	
	@Transactional
	public void createOrder(OrderRequestDTO orderRequestDto) {
		
		 double totalBillAmount = 0;
		 List<ProductResponseDTO> cacheProduct = new ArrayList<>();
		
		List <ItemsRequestDTO> OrderedItems = orderRequestDto.getItemsRequestDto();
			for (ItemsRequestDTO item : OrderedItems) {
				ProductResponseDTO product = httpClient.getProductById(item.getProductId());
				System.out.println("va product : " + product.getName() + " , " + product.getPrice() + " , " + product.getQuantity() + " , " 
						+ product.getProductId());
				    if (product == null) {
				    	throw new ExternalServiceException("product is not present in the inventory. Search for the new project");
				    }
				    
				    if (product.getQuantity() < item.getQuantity()) {
				    	throw new NotAvailableException("Product is either not available or the required quantity is not present in the "
				    			+ "inventory : " + item.getProductName() + "|" + "Available quantity in the inventory : "  + product.getQuantity());
				    }
				        double price = item.getQuantity() * product.getPrice();
				        totalBillAmount += price;
				        
				        cacheProduct.add(product);
			       
			}
			
			//save to order table
			Orders order = new Orders();
			order.setOrderBy(orderRequestDto.getOrderedBy());
			order.setBillAmount(totalBillAmount);
			order.setOrderDate(LocalDateTime.now());
			
		//	Orders saveOrder = ordersRepository.save(order);
			
			List<Items> itemList = new ArrayList<>();
			
			for(int i = 0; i < OrderedItems.size(); i++) {
				ItemsRequestDTO orderItem = OrderedItems.get(i);
				ProductResponseDTO productForOrdereredItem = cacheProduct.get(i);
				
				Items finalItem = new Items();
				finalItem.setProductId(productForOrdereredItem.getProductId());
				finalItem.setProductName(productForOrdereredItem.getName());
				finalItem.setQuantity(orderItem.getQuantity());
			//	finalItem.setOrder(saveOrder);
				finalItem.setOrder(order);
				
				itemList.add(finalItem);
				
				order.setItems(itemList);
				ordersRepository.save(order);

						
			}
			
			
			
			
		
	}

}
