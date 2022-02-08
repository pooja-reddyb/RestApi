package com.example.demo.service;

import java.util.List;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepository;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.mapper.UserMapper;


//@Service
//public class UserServiceImpl implements UserService{
//	
//	@Autowired
//	private UserRepository userRepository;
//	
//	@Autowired
//	private UserMapper mapper;
//
//	public UserDto createUser(User user) {
//		User create = userRepository.save(user);
//		return mapper.convertToDto(user);
//		
//		
//	}
//
//
//
//	public UserDto getUserById(int id) {
//		User retrive = userRepository.findById(id).orElse(null);
//		return mapper.convertToDto(retrive);
//		
//		
//	}
//
//	public List<UserDto> getUsers() {
//		List<User> retriveAll = userRepository.findAll();
//		return mapper.toDtoList(retriveAll);
//		
//		
//	} 
//
//}

@Service
public class UserServiceImpl implements UserService{


@Autowired
private UserRepository userRepository;


@Autowired
private UserMapper mapper;


Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

@Override
public UserDto createUser(UserDto user) {
User create = userRepository.save(mapper.convertToEntity(user));
return mapper.convertToDto(create);

}

@Override
public String healthcheck(int id) {
Optional<User> s = userRepository.findById(id);
if(s.isPresent()) {
return ("HealthCheck Successful");
}
else {
return ("HealthCheck Failed");
}
}





@Override
public User getUserById(int id) throws UserNotFoundException {
Optional<User> user = userRepository.findById(id);
User s = null;
if(user.isPresent()) {
s = user.get();
logger.info("retrieve all method in progress");
return s;
}
//if(user.isEmpty()) {
//	//logger.info("No Records Found");
//	throw new UserNotFoundException("No Records Found");
//	
//}
else
	throw new UserNotFoundException("No Records Found");
}
//@Override
//public User getUserById(int id)
//{
//	return userRepository.getById(id);
//}
//@Override
//public User getUserById(int id) {
//	return userRepository.findById(id).get();
//}


@Override
public List<UserDto> getUsers() {
List<User> retriveAll = userRepository.findAll();
return mapper.toDtoList(retriveAll);



}





}
