package com.io.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProductService {

	@Autowired
	public ProductRepository productRepository;

	public List<Product> listAll() {
		return productRepository.findAll();
	}

	public Product findById(Integer id) {
		return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
//		return productRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product with id " + id + " not found"));
	}

	
	public void delete(Integer id) {
		productRepository.deleteById(id);
    }

	public Product createProduct(Product product) {
		
		return productRepository.save(product);
	}
}
