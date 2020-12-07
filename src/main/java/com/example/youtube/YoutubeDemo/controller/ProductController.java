package com.example.youtube.YoutubeDemo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.youtube.YoutubeDemo.entities.Product;
import com.example.youtube.YoutubeDemo.services.ProductJPARepository;

@RestController
public class ProductController {
	
	@Autowired
	private ProductJPARepository productService;

	@GetMapping("/welcome")
	public String sayHi() {
		return "Welcome to Product Page";
	}
	
	@GetMapping("/product")
	public Product getProduct() {
		Product myProduct = new Product(1, "A", 10);
		return myProduct;
	}
	
	@GetMapping("/products")
	public List<Product> getProducts() {
		return productService.findAll();
	}
	
	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable int id) {
		return productService.findById(id).get();
	}
	
	@DeleteMapping("/products/{id}")
	public String deleteProductById(@PathVariable int id) {
		productService.deleteById(id);
		return "1";
	}
	
	@PostMapping("/products")
	public String addProduct(@RequestBody Product product) {
		productService.save(product);
		return "ok";
	}
	
}
