package com.p1.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.p1.entity.Product;

public interface ProductRepository extends ReactiveCrudRepository<Product, Long> {

}

//  save(,1"iphone17, 3000, helloo)  findById  FindAll deleteByID  existsById count()
