package com.example.demo.exception;


public class UserNotFoundException extends RuntimeException {
private final long serialVersionUID = -3667906938721609814L;

public UserNotFoundException(String message) {
super(message);
}

public UserNotFoundException(String message, Throwable cause) {
	super(message, cause);
	// TODO Auto-generated constructor stub
}


}
