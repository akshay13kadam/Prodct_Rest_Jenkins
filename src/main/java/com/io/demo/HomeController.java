package com.io.demo;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@Autowired
	public ProductService productService;
//	
//	@Autowired
//	public ProductRepository productRepository;
	
//	
	@GetMapping("/home2")
	public String home1() {

		return "Welcome to first demo page";

	}
	
	@GetMapping("/home3")
	public String home3() {

		return "Welcome to first demo page";

	}
	
	@GetMapping("/home")
	public String home() {

		return "Welcome to first demo page";

	}
	
	@GetMapping("/products")
	public List<Product> list() {
	    return productService.listAll();
	}
	
	

	
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProdutById(@PathVariable Integer id) {
//	    try {
//	      Optional<Product> p= Optional.of(productService.findById(id));
//	     Product p=productService.findById(id); 
	    	Product p=productService.findById(id);

	      System.out.println("Exception   "+p);
	        return new ResponseEntity<Product>(p, HttpStatus.OK);
//	      return p.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.badRequest().build());
	      
//	    } catch (NoSuchElementException e) {
//	        return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
//	    }      
	}
	
	@DeleteMapping("/products/{id}")
	public void delete(@PathVariable Integer id) {
		productService.delete(id);
	}
	
	@PostMapping("/products")
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		
		Product product2 = productService.createProduct(product);
		return new ResponseEntity<Product>(product2,HttpStatus.CREATED);
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Integer id) {
	    try {
	        Product existingProduct = productService.findById(id);
	        
	        existingProduct.setProductName(product.getProductName());
	        existingProduct.setProductQunatity(product.getProductQunatity());
	        existingProduct.setProductPrice(product.getProductPrice());
	    
	        Product updatedProduct = productService.createProduct(existingProduct);
	        return new ResponseEntity<>(updatedProduct,HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
}
