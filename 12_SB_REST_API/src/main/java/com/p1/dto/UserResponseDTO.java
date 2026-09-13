package com.p1.dto;

public class UserResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String phone;
    
    private String profileImage;
    
    private String resume;
    
    

	public UserResponseDTO() {
		super();
	}



	public UserResponseDTO(Long id, String name, String email, String phone, String profileImage, String resume) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.profileImage = profileImage;
		this.resume = resume;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getProfileImage() {
		return profileImage;
	}



	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}



	public String getResume() {
		return resume;
	}



	public void setResume(String resume) {
		this.resume = resume;
	}
	
	
    


}