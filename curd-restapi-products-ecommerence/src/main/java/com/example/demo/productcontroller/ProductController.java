package com.example.demo.productcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.productdto.ProductDTO;
import com.example.demo.productentity.ProductEntity;
import com.example.demo.productservice.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductService service;

	//CREATE
	@PostMapping
	public ProductEntity createProduct(@Valid @RequestBody ProductDTO dto)
	{
		return service.createProduct(dto);

	}
	
	//Real ALL
	@GetMapping
	public List<ProductEntity> getAllProducts(){
		return service.getAllProducts();
		
	}
	
	//RealByID
	
	@GetMapping("/{id}")
	public ProductEntity getProductById(@PathVariable Long id) {
		return service.getProductById(id);
	}
	
	
// Update - put
	@PutMapping("/{id}")
	
	public ProductEntity updateProduct( @PathVariable Long id , @Valid @RequestBody ProductDTO dto) {
		return service.updateProduct(id, dto);
		
	}
	
	//Delete
	
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable Long id) {
		service.deleteProduct(id);
		return " product deleted successfully";
	}
	
}
