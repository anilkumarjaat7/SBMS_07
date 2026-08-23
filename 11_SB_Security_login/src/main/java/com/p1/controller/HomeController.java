package com.p1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/user/home")
	public String userHome() {
		return "user";
	}
	
	
	@GetMapping("/admin/home")
	public String adminHome() {
		return "admin";
	}

}
