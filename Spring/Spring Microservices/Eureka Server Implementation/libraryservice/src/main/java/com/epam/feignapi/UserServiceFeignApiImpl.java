package com.epam.feignapi;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.epam.dto.UserDTO;

@Service
public class UserServiceFeignApiImpl implements UserServiceFeignApi {
	
	private UserDTO fallback = new UserDTO();

	@Override
	public ResponseEntity<UserDTO> addUser(UserDTO userDTO) {
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(fallback);
	}

	@Override
	public ResponseEntity<UserDTO> getUserByUserId(long userId) {
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(fallback);
	}

	@Override
	public ResponseEntity<List<UserDTO>> getAllUsers() {
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(List.of(fallback));
	}

	@Override
	public ResponseEntity<UserDTO> deleteUser(long userId) {
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(fallback);
	}

	@Override
	public ResponseEntity<UserDTO> updateUser(UserDTO userDTO, long userId) {
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(fallback);
	}

	@Override
	public ResponseEntity<String> getUserServicePort() {
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("fallback");
	}
	
}
