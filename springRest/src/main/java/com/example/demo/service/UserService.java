package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepository;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFoundException;


public interface UserService  {
	
//	public UserDto createUser(User user);
//
//
//	public UserDto getUserById(int id); 
//
//	public List<UserDto> getUsers(); 
//	
	public UserDto createUser(@Valid UserDto user);


	public User getUserById(int id) throws UserNotFoundException;



	public List<UserDto> getUsers();


	public String healthcheck(int id);
	
	
	
	
	
	

}