package com.KeellsOrder.KeellsOrder.httpClient;



import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.KeellsOrder.KeellsOrder.dto.ProductResponseDTO;

//we need this for clean architecture
//client is used to talk to other services
@Component
public class HttpClient {
	
	private final RestTemplate restTemplate;
	
	public HttpClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	
	public ProductResponseDTO getProductById(Long id) {
	    String url =
	            "http://localhost:8080/inventoryServices/getProductById?id={id}";

	        return restTemplate.getForObject(
	                url,
	                ProductResponseDTO.class,
	                id
	        );
	}
}
