package com.tcs.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getDetails(){
		return productRepository.findAll();
	}

	public void saveProduct(Product product) {
		productRepository.save(product);
		
	}


	public void deletePro(Long id) {
		productRepository.deleteById(id);
		
	}

	public Product editPro(long id) {
		
		Product product  = productRepository.findById(id).get();
		return product;
		
	}

}
