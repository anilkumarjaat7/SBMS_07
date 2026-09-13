package com.p1.service.imp;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



@Service
public class FileStorageServiceImpl {

	private final Path upladPath ;

	public FileStorageServiceImpl( @Value("${file.upload-dir}") String uploadDir) {
		
		this.upladPath = Paths.get(uploadDir).toAbsolutePath().normalize();
		
		try {
			  Files.createDirectories(
	                    upladPath.resolve("profile-images"));
			  
			  Files.createDirectories(
	                    upladPath.resolve("resumes"));
		}catch(IOException e) {
			throw new RuntimeException("Could not create upload Folder");
		}
   
		
	}
	
	
//	save Profile Img
	
	public String saveProfileImage(MultipartFile file) {
		
		if(file == null || file.isEmpty()) {
			return null;
		}
		
		
		String originalFileName  = file.getOriginalFilename();
		
		String extesion = "";
		
	extesion=	originalFileName.substring(originalFileName.lastIndexOf("."));
		
	String fileName=	UUID.randomUUID().toString()+extesion;
	
	Path filePath = upladPath.resolve("profile-images").resolve(fileName);
	
	try {
		Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
	}catch (IOException ex) {
		
		throw new RuntimeException("could not save profile image");
		
	}
	
	
	return fileName;
		
	}
	
	
//	save Resume
	public String saveResume(MultipartFile file) {
		
		if(file == null || file.isEmpty()) {
			return null;
		}
		
		
String originalFileName  = file.getOriginalFilename();
		
		String extesion = "";
	
		if(originalFileName != null && originalFileName.contains(".")) {
			
			extesion=	originalFileName.substring(originalFileName.lastIndexOf("."));

		}
		
		
			
	String fileName=	UUID.randomUUID().toString()+extesion;
	
	Path filePath = upladPath.resolve("resumes").resolve(fileName);
	
	
	  try {

          Files.copy(
                  file.getInputStream(),
                  filePath,
                  StandardCopyOption.REPLACE_EXISTING
          );

      } catch (IOException e) {

          throw new RuntimeException(
                  "Could not save resume");
      }
	
	return fileName;
		
		
	}
	
	
	
	

}
