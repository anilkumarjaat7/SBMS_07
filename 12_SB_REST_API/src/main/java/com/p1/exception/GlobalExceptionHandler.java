package com.p1.exception;


import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

//	user Not Found
	
	   @ExceptionHandler(UserNotFoundException.class)
	    public ResponseEntity<Map<String, Object>>
	    handleUserNotFound(UserNotFoundException ex) {

	        Map<String, Object> response =
	                new HashMap<>();

	        response.put("status", 404);
	        response.put("message", ex.getMessage());

	        return ResponseEntity
	                .status(HttpStatus.NOT_FOUND)
	                .body(response);
	    }

	   @ExceptionHandler(
	            MethodArgumentNotValidException.class
	    )
	  public ResponseEntity<Map<String, Object>> handleValidation(MethodArgumentNotValidException ex) {
		  
		  
		  Map<String, String> errors =
	                new HashMap<>();
		  
		  for (var error :
              ex.getBindingResult().getFieldErrors()) {

          errors.put(
                  error.getField(),
                  error.getDefaultMessage()
          );
      }

      Map<String, Object> response =
              new HashMap<>();

      response.put("status", 400);
      response.put("errors", errors);

      return ResponseEntity
              .status(HttpStatus.BAD_REQUEST)
              .body(response);
  }
	  
	  
	  @ExceptionHandler(Exception.class)
	    public ResponseEntity<Map<String, Object>>
	    handleGeneralException(Exception ex) {
		  
		  Map<String, Object> response =
	                new HashMap<>();

	        response.put("status", 500);
	        response.put(
	                "message",
	                "Something went wrong"
	        );

	        return ResponseEntity
	                .status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body(response);
	    }
	
}
