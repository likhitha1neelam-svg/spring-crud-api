package com.example.demo.productdto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

//validation dependency should add in pom.xml

public class ProductDTO {
	
	@NotBlank(message ="name is required")
	
	private String name;
	
	@Positive(message =" price should be positive")
	private Double price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}


}
