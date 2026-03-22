package com.example.demo.productrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.productentity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity,Long>{

	
}
