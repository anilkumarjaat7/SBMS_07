package com.p1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@GetMapping
	public String getProducts() {
		return "products Api -  All products get";
	}
	
	@GetMapping("/admin")
	public String adminProducts() {
		return "Admin products Api -get  products ";
	}
	
	@GetMapping("/delete")
	public String admindeleteProduct() {
		return "admin delete Product";
	}

}
