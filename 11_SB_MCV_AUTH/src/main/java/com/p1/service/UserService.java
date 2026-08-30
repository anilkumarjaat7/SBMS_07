package com.p1.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.p1.entity.User;
import com.p1.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository repo;

	public UserService(UserRepository repo) {
		super();
		this.repo = repo;
	}
	
	
	
//	Singup 
	
	
	public User rigsterUser(User user) {
		
		return repo.save(user);
	}
	
//	find User By Email
	
	public User findByEmail(String email) {
		Optional<User> user = repo.findByEmail(email);
		
		return user.orElse(null);
	}
	
	
//	Login
	
	public User Login(String email, String password) {
		User user = findByEmail(email);
		
		if(user != null && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}
	
	

}
