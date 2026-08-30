package com.p1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.p1.entity.User;
import com.p1.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {
	
	private final UserService service;

	@Autowired
	public AuthController(UserService service) {
		super();
		this.service = service;
	}
	
	
//	Home
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	
//	singup page
	@GetMapping("/signup")
public String signup() {
	return "signup";
}
	@PostMapping("/signup")
	public String register(User user,Model model) {
		
		User existingUser = service.findByEmail(user.getEmail());
		
		if( existingUser != null) {
			model.addAttribute("error", "Email already registered")	;
			return "signup";
			}
		
		service.rigsterUser(user);
		
		return "redirect:/login";
		
	}
	
    // Login page
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    
    
    @PostMapping("/login")
	public String loginUser(@RequestParam String email, @RequestParam String password,HttpSession session , Model model) {
		
		User user = service.Login(email, password);
		
		if(user != null) {
			session.setAttribute("user", user);
			  return "redirect:/dashboard";
		}
		
		model.addAttribute("error", "Invalid Email or Password");
		
		return "login";
	}
    
    @GetMapping("/dashboard")
    public String dashbord(HttpSession session, Model model) {
    	
    	
    	User user = (User)session.getAttribute("user");
    	
    	
    	if(user == null) {
    		 return "redirect:/login";
    	}
    	
    	model.addAttribute("user", user);
    	return "dashboard";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	
    	return "redirect:/";
    }
    


	
	

}
