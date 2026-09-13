package com.p1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDTO {
	
	private Long id;
	
	private String name;
	
	private String email;
	
	private String phone;
	
	private Integer age;
	
	private String course;
	
	private Double fees;

}
