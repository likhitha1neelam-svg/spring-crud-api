package com.example.demo.productexceptionhandling;

public class ProductCustomException extends RuntimeException{
	
	public ProductCustomException(String message){
		super(message);
	}
}
