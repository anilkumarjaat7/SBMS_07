package com.p1.exception;


public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }
}


// throw new UserNotFoundException("user not found with name " name);



 

