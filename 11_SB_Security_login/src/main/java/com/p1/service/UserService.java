package com.p1.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.p1.entity.User;
import com.p1.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	
	
	
	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}




	public User rigsterUser(User user) {
		
	String encodepassword =	passwordEncoder.encode(user.getPassword());
	user.setPassword(encodepassword);
		return userRepository.save(user);
		
	}
	
	
	
	

}
