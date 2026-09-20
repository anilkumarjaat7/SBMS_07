package com.p1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@GetMapping("/login")
	public String getProducts() {
		return "user login succfully";
	}
	
	@GetMapping("/singup")
	public String adminProducts() {
		return "user singup succfully  ";
	}
	

}