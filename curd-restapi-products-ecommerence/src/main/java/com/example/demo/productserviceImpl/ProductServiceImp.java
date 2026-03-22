package com.example.demo.productserviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.productdto.ProductDTO;
import com.example.demo.productentity.ProductEntity;
import com.example.demo.productexceptionhandling.ProductCustomException;
import com.example.demo.productrepository.ProductRepository;
import com.example.demo.productservice.ProductService;


@Service
public class ProductServiceImp implements ProductService {
	
	@Autowired
	private ProductRepository repo;
	@Autowired
	private org.modelmapper.ModelMapper modelMapper; // required entire line

	@Override
	public ProductEntity createProduct(ProductDTO dto) {
		
		ProductEntity product = modelMapper.map(dto,ProductEntity.class);
		return repo.save(product) ;
	}

	@Override
	public List<ProductEntity> getAllProducts() {
		
		return repo.findAll();
	}

	@Override
	public ProductEntity getProductById(Long id) {
		return repo.findById(id).orElseThrow(()->new ProductCustomException("Product not found" +id));
		
		
	}

	@Override
	public ProductEntity updateProduct(Long id, ProductDTO dto) {
		
		ProductEntity existing = repo.findById(id).orElseThrow(()->new ProductCustomException("Product not found" +id));
		 modelMapper.map(dto,existing);
		return repo.save(existing);
	}
	/*@Override
	public ProductEntity getProductById(Long id) {
		return repo.findById(id).orElseThrow(()->new RuntimeException("Product not found" +id));
		
		
	}

	@Override
	public ProductEntity updateProduct(Long id, ProductDTO dto) {
		
		ProductEntity existing = repo.findById(id).orElseThrow(()-> new RuntimeException("Product not found" +id));
		 modelMapper.map(dto,existing);
		return repo.save(existing);
	}*/
	/*@Override
public ProductEntity updateProduct(Long id, ProductDTO dto) {

    ProductEntity existing = repo.findById(id)
        .orElseThrow(() -> new RuntimeException("Product not found " + id));

    // update fields from DTO
    existing.setName(dto.getName());
    existing.setPrice(dto.getPrice());

    return repo.save(existing);
}
	 
	 */

	@Override
	public void deleteProduct(Long id) {
		repo.deleteById(id);
		
	}

}
