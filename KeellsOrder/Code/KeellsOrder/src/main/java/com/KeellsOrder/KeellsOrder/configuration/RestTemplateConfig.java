package com.KeellsOrder.KeellsOrder.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
	
	
	//spring executed this method--takes the returned object--stores it in the container
	//That’s why it only works on methods, not classes or fields.
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
