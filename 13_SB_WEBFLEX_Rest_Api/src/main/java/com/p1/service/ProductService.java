package com.p1.service;

import org.springframework.stereotype.Service;

import com.p1.entity.Product;
import com.p1.repository.ProductRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
	
	private ProductRepository repository;

	public ProductService(ProductRepository repository) {
		super();
		this.repository = repository;
	}
	
	
//	create
	
	public Mono<Product> saveProduct(Product product) {
		  return repository.save(product);
	}
	
//	Read All
	
	public 	 Flux<Product> getAllProducts() {
	return repository.findAll();
	}
	
//	 Read One 
	
	public  Mono<Product> getProductById(Long Id) {
		return repository.findById(Id);
	}
	
//	update
	
	
	
	
//	delete
	
	public Mono<Void> deleteProduct(Long id){
		return repository.deleteById(id);
	}

}
