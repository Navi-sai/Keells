package com.KeellsOrder.KeellsOrder.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NotAvailableException.class)
	public String handleNotAvailableException(NotAvailableException e) {
		return e.getMessage();
	}
	
	@ExceptionHandler(ExternalServiceException.class)
	public String handleExternalServiceException(ExternalServiceException ex) {
		return ex.getMessage();
	}

}
