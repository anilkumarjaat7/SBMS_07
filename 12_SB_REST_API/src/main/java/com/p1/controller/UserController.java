package com.p1.controller;

import org.springframework.http.MediaType;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.p1.dto.UserRequestDTO;
import com.p1.dto.UserResponseDTO;
import com.p1.service.imp.UserServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	private UserServiceImpl userService;

	public UserController(UserServiceImpl userService) {
		super();
		this.userService = userService;
	}
	
//	create Student 
	@PostMapping(
		    consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<UserResponseDTO> createUser(@Valid @ModelAttribute UserRequestDTO request){
		
		UserResponseDTO Response = userService.createUser(request);
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(Response);
	}
	
	
//	Get All User
	@GetMapping
    public ResponseEntity<List<UserResponseDTO>>
    getAllUsers() {

        List<UserResponseDTO> response =
                userService.getAllUsers();

        return ResponseEntity.ok(response);
    }
	
	

//	Get By id
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO>
    getUserById(
            @PathVariable Long id) {

        UserResponseDTO response =
                userService.getUserById(id);

        return ResponseEntity.ok(response);
    }
	
//    secarch user by name
    @GetMapping("/search")
    public ResponseEntity<List<UserResponseDTO>>
    searchUsers(
            @RequestParam String name) {

        List<UserResponseDTO> response =
                userService.searchUsers(name);

        return ResponseEntity.ok(response);
    }
	
    
//    update user

    @PutMapping(value="/{id}" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<UserResponseDTO>
    updateUser(
            @PathVariable Long id,

            @Valid
            @ModelAttribute UserRequestDTO request) {

        UserResponseDTO response =
                userService.updateUser(id, request);

        return ResponseEntity.ok(response);
    }
    
    
//    delete user

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>
    deleteUser(
            @PathVariable Long id) {

        userService.deleteUser(id);

        return ResponseEntity
                .noContent()
                .build();
    }

	
	

}
