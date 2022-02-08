package com.example.demo.exception;

import java.util.Date;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
//	// handling specific exception
//		@ExceptionHandler(value = {UserNotFoundException.class})
//		public ResponseEntity<Object> resourceNotFoundHandling(UserNotFoundException exception, WebRequest request){
//			ErrorDetails errorDetails = 
//					new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
//			return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//		}
//		
//		
//	// handling specific exception
//		@ExceptionHandler(UserNotAddedException.class)
//		public ResponseEntity<?> resourceNotFoundHandling(UserNotAddedException exception, WebRequest request){
//			ErrorDetails errorDetails = 
//					new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
//			return new ResponseEntity<>(errorDetails, HttpStatus.NO_CONTENT);
//		}
		
		@ExceptionHandler(UserNotFoundException.class)
		//@ResponseStatus(value = HttpStatus.NOT_FOUND)
		public ResponseEntity<String> employeeNotFound(UserNotFoundException exception) {
		//return exception.getMessage();
		return new ResponseEntity<String>("No Users available",HttpStatus.NOT_FOUND);
		}
		
}
