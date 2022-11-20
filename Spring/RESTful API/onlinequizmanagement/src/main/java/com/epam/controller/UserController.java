package com.epam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.dto.UserDto;
import com.epam.entity.User;
import com.epam.exception.CredentialsMismatchExcpetion;
import com.epam.exception.EmptyFieldException;
import com.epam.exception.NoSuchFieldException;
import com.epam.exception.ResourceNotFoundException;
import com.epam.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto)
			throws EmptyFieldException, ResourceNotFoundException, NoSuchFieldException {
		
		if(userDto.getUsername()==null || userDto.getPassword()==null) {
			throw new NoSuchFieldException("Field cannot be null. Make sure every key is provided with correct name");
		}
		
		if(userDto.getUsername().isBlank() || userDto.getPassword().isBlank()) {
			throw new EmptyFieldException("Username or password cannot be blank.");
		}
		
		User user = User.builder()
				.username(userDto.getUsername())
				.password(userDto.getPassword())
				.role("student")
				.build();
		
		User dbUser = userService.register(user);
		
		UserDto userDtoResponse = UserDto.builder()
				.username(dbUser.getUsername())
				.password(dbUser.getPassword())
				.role(dbUser.getRole())
				.id(dbUser.getId())
				.build();
		
		return ResponseEntity.status(HttpStatus.OK).body(userDtoResponse);

	}
	
	@GetMapping("/login")
	public ResponseEntity<UserDto> loginUser(@RequestBody UserDto userDto) 
			throws EmptyFieldException, ResourceNotFoundException, NoSuchFieldException, CredentialsMismatchExcpetion {
		
		if(userDto.getUsername()==null || userDto.getPassword()==null) {
			throw new NoSuchFieldException("Field cannot be null. Make sure every key is provided with correct name");
		}
		
		if(userDto.getUsername().isBlank() || userDto.getPassword().isBlank()) {
			throw new EmptyFieldException("Username or password cannot be blank.");
		}
		
		User dbUser = userService.getUserByUsername(userDto.getUsername()).orElseThrow(
				()->new ResourceNotFoundException("This username doesn't exists. Make sure you have registered."));
		
		if(!dbUser.getPassword().equals(userDto.getPassword())) {
			throw new CredentialsMismatchExcpetion("Username or password is wrong");
		}
		
		UserDto userDtoResponse = UserDto.builder()
				.username(dbUser.getUsername())
				.password(dbUser.getPassword())
				.role(dbUser.getRole())
				.id(dbUser.getId())
				.build();
		
		return ResponseEntity.status(HttpStatus.OK).body(userDtoResponse);

	}
	
}
