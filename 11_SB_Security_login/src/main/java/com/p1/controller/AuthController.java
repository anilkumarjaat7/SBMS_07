package com.p1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.p1.entity.User;
import com.p1.service.UserService;

@Controller
public class AuthController {
	
	private final UserService userSevice;

	   

	    public AuthController(UserService userSevice) {
		super();
		this.userSevice = userSevice;
	}

		@GetMapping("/signup")
	    public String signupPage(Model model) {

	        model.addAttribute("user", new User());

	        return "singup";
	    }

	    @PostMapping("/signup")
	    public String signup(@ModelAttribute User user) {

	        userSevice.rigsterUser(user);

	        return "redirect:/login";
	    }

	    @GetMapping("/login")
	    public String loginPage() {

	        return "login";
	    }

}
