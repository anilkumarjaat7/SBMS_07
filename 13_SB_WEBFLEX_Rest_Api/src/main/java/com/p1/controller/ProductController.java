package com.p1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.p1.entity.Product;
import com.p1.service.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/products")
public class ProductController {

	private ProductService service;

	public ProductController(ProductService service) {
		super();
		this.service = service;
	}
	
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Product> createProduct(@RequestBody Product product) {
		return  service.saveProduct(product);
	}
	
//	Read All
	
	@GetMapping
	public 	Flux<Product> getAllProducts() {
	 return service.getAllProducts();
		
	}
	
	
	@GetMapping("/{id}")
	public 	Mono<Product> getProductsById(@PathVariable int id) {
	 return service.getProductById(null);
		
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	  public Mono<Void> deleteProduct(
	            @PathVariable Long id) {

	        return service.deleteProduct(id);
	    }
	
	
	
}
