package com.example.demo.productservice;

import java.util.List;



import com.example.demo.productdto.ProductDTO;
import com.example.demo.productentity.ProductEntity;



public interface ProductService  {

	ProductEntity createProduct(ProductDTO dto);

    List<ProductEntity> getAllProducts();

    ProductEntity getProductById(Long id);

    ProductEntity updateProduct(Long id, ProductDTO dto);

    void deleteProduct(Long id);
}
