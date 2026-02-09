package com.io.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
//@Table(name="products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
	
	@NotBlank(message = "Product Name is mandatory")
	@Size(min = 3, message = "Product name must be at least 3 characters long")
	private String productName;
	
	private int productQunatity;
	private double productPrice;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductQunatity() {
		return productQunatity;
	}
	public void setProductQunatity(int productQunatity) {
		this.productQunatity = productQunatity;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", productQunatity=" + productQunatity
				+ ", productPrice=" + productPrice + "]";
	}
	public Product(Integer id, String productName, int productQunatity, double productPrice) {
		super();
		this.id = id;
		this.productName = productName;
		this.productQunatity = productQunatity;
		this.productPrice = productPrice;
	}
	public Product() {
		super();
	}
	
	
	
	
	
	
	
	
	
}
