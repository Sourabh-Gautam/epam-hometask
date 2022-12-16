package com.epam.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.epam.dto.UserDTO;
import com.epam.entity.User;
import com.epam.exception.UserNotFoundException;
import com.epam.service.UserService;

@RestController
public class UserController {

	private ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private UserService userService;
	

	@PostMapping("/users")
	public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
		User user = modelMapper.map(userDTO, User.class);
		User userDb = userService.addUser(user);
		return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(userDb, UserDTO.class));
	}

	@GetMapping("/users/{user_id}")
	public ResponseEntity<UserDTO> getUserByUserId(@PathVariable("user_id") long userId) throws UserNotFoundException {
		User user = userService.getUserByUserId(userId)
				.orElseThrow(() -> new UserNotFoundException("No User is available having userId " +userId));
		return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(user, UserDTO.class));
	}

	@GetMapping("/users")
	public ResponseEntity<List<UserDTO>> getAllUsers() {
		List<User> users = userService.getAllUsers();
		List<UserDTO> userDTOs = users.stream().map(e -> modelMapper.map(e, UserDTO.class))
				.collect(Collectors.toList());
		
	
		
		return ResponseEntity.status(HttpStatus.OK).body(userDTOs);
	}

	@DeleteMapping("/users/{user_id}")
	public ResponseEntity<UserDTO> deleteUser(@PathVariable("user_id") long userId) throws UserNotFoundException {
		User user = userService.getUserByUserId(userId)
				.orElseThrow(() -> new UserNotFoundException("No User is available having userId" +userId));
		userService.deleteBookByUserId(userId);
		return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(user, UserDTO.class));
	}

	@PutMapping("/users/{user_id}")
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO, @PathVariable("user_id") long userId )
			throws UserNotFoundException {
		User userDb = userService.getUserByUserId(userId)
				.orElseThrow(() -> new UserNotFoundException("No User is available having userId " +userId));
		userDb.setUsername(userDTO.getUsername());
		userDb.setName(userDTO.getName());
		userDb.setEmail(userDTO.getEmail());
	
		User updatedBook = userService.updateUserByUserId(userDb);
		return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(updatedBook, UserDTO.class));
	}

}
