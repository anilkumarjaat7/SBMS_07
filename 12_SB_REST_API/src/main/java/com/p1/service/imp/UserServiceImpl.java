package com.p1.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.p1.dto.UserRequestDTO;
import com.p1.dto.UserResponseDTO;
import com.p1.entity.User;
import com.p1.exception.UserNotFoundException;
import com.p1.repository.UserRepository;
import com.p1.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	
	private final UserRepository repo;
	
	private final FileStorageServiceImpl fileStorageService;
	
	
   

	public UserServiceImpl(UserRepository repo, FileStorageServiceImpl fileStorageService) {
		super();
		this.repo = repo;
		this.fileStorageService = fileStorageService;
	}

	@Override
	public UserResponseDTO createUser(UserRequestDTO request) {
	User user=	new User();
	
	  user.setName(request.getName());
      user.setEmail(request.getEmail());
      user.setPhone(request.getPhone());
      
//      save Profile Image
      
      if(request.getProFileImage() !=null && !request.getProFileImage().isEmpty()) {
    	String imageName=  fileStorageService.saveProfileImage(request.getProFileImage());
    	
    	user.setProfileImage(imageName);
      }
      
//      save Resume
      if(request.getResume() != null && !request.getResume().isEmpty()) {
    	String resumeName =  fileStorageService.saveResume(request.getResume());
    	user.setResume(resumeName);
      }

      User savedUser = repo.save(user);

      UserResponseDTO response = new UserResponseDTO();
      
      
	
      response.setId(savedUser.getId());
      response.setName(savedUser.getName());
      response.setEmail(savedUser.getEmail());
      response.setPhone(savedUser.getPhone());
      response.setProfileImage(savedUser.getProfileImage());
      response.setResume(savedUser.getResume());

      return response;
	}

	@Override
	public List<UserResponseDTO> getAllUsers() {
		List<User> users = repo.findAll();

        List<UserResponseDTO> responseList =
                new ArrayList<>();

        for (User user : users) {

            UserResponseDTO response =
                    new UserResponseDTO();

            response.setId(user.getId());
            response.setName(user.getName());
            response.setEmail(user.getEmail());
            response.setPhone(user.getPhone());
            response.setProfileImage(user.getProfileImage());
            response.setResume(user.getResume());

            responseList.add(response);
        }

        return responseList;
    }

	@Override
	public UserResponseDTO getUserById(Long id) {
	
		 User user = repo.findById(id)
				 .orElseThrow(() ->
                 new UserNotFoundException(
                         "User not found with id: " + id
                 )
         );
	                
	                     

	        UserResponseDTO response =
	                new UserResponseDTO();

	        response.setId(user.getId());
	        response.setName(user.getName());
	        response.setEmail(user.getEmail());
	        response.setPhone(user.getPhone());
	        response.setProfileImage(user.getProfileImage());
	        response.setResume(user.getResume());

	        return response;
	    }

	 @Override
	    public List<UserResponseDTO> searchUsers(String name) {

	        List<User> users =
	                repo.findByNameContainingIgnoreCase(name);

	        List<UserResponseDTO> responseList =
	                new ArrayList<>();

	        for (User user : users) {

	            UserResponseDTO response =
	                    new UserResponseDTO();

	            response.setId(user.getId());
	            response.setName(user.getName());
	            response.setEmail(user.getEmail());
	            response.setPhone(user.getPhone());
	            response.setProfileImage(user.getProfileImage());
	            response.setResume(user.getResume());

	            responseList.add(response);
	        }

	        return responseList;
	    }

	@Override
	public UserResponseDTO updateUser(Long id, UserRequestDTO request) {
		 User user = repo.findById(id)
				 .orElseThrow(() ->
                 new UserNotFoundException(
                         "User not found with id: " + id
                 )
         );
	                
	               

	        user.setName(request.getName());
	        user.setEmail(request.getEmail());
	        user.setPhone(request.getPhone());
	        
//	      save Profile Image
	        
	        if(request.getProFileImage() !=null && !request.getProFileImage().isEmpty()) {
	      	String imageName=  fileStorageService.saveProfileImage(request.getProFileImage());
	      	
	      	user.setProfileImage(imageName);
	        }
	        
//	        save Resume
	        if(request.getResume() != null && !request.getResume().isEmpty()) {
	      	String resumeName =  fileStorageService.saveResume(request.getResume());
	      	user.setResume(resumeName);
	        }

	        

	        User updatedUser =
	                repo.save(user);

	        UserResponseDTO response =
	                new UserResponseDTO();

	        response.setId(updatedUser.getId());
	        response.setName(updatedUser.getName());
	        response.setEmail(updatedUser.getEmail());
	        response.setPhone(updatedUser.getPhone());
	        response.setProfileImage(updatedUser.getProfileImage());
	        response.setResume(updatedUser.getResume());

	        return response;
	}

	@Override
	public void deleteUser(Long id) {
		
	User user =	repo.findById(id)
			 .orElseThrow(() ->
            new UserNotFoundException(
                    "User not found with id: " + id
            )
    );
	
	repo.delete(user);
	
  
	}

}
