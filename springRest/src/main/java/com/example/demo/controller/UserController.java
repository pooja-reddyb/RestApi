package com.example.demo.controller;

import java.util.List;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.service.UserService;


@RestController
@Validated
@RequestMapping("/mainApp")
public class UserController {
	@Autowired
	private UserService userService;
	
	Logger logger = LoggerFactory.getLogger(UserController.class);

	@PostMapping("/addUser/post")
	@ResponseStatus(HttpStatus.CREATED)
	public String addUser(@RequestBody @Valid UserDto user) {
		UserDto savedUser = userService.createUser(user);
		//return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
		return "user saved successfully";
//				.orElseThrow(() -> new UserNotAddedException("User not added"));
	}
	
	@GetMapping("/health/{id}")
	public ResponseEntity<String> healthcheck(@PathVariable int id){
	String str = userService.healthcheck(id);
	logger.info("HealthCheck Successful");
	return new ResponseEntity<String>(str, HttpStatus.CREATED);
	}

	@GetMapping("/user/{id}")
		public ResponseEntity<User> getUserById(@PathVariable @NotNull int id) throws UserNotFoundException {
		User user= userService.getUserById(id);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
//	@GetMapping("/user/{id}")
//	public ResponseEntity<User> getUserById(@PathVariable  int id)  {
//	User user= userService.getUserById(id);
//	if(user!=null) {
//	return new ResponseEntity<User>(user, HttpStatus.CREATED);
//	}
//	else {
//		throw new UserNotFoundException("Oops record not found");
//		
//	}

	

	
	

	@GetMapping("/users/get")
	public ResponseEntity<?> getAllUsers(){
		List<UserDto>  users = userService.getUsers();
		return ResponseEntity.ok(users);
	}
	
	
}
