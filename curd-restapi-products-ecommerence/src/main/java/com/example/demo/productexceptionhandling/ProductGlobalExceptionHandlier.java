package com.example.demo.productexceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductGlobalExceptionHandlier {
	
	@ExceptionHandler(ProductCustomException.class)
	public ResponseEntity<String> handleProductNotFound(ProductCustomException ex){
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
		
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGenericException(Exception ex ){
		return new ResponseEntity<>("Internal server error"+ ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
