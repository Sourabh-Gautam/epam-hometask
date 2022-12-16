package com.epam.feignapi;

import java.util.List;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.epam.dto.UserDTO;

@FeignClient(name = "userservice", fallback = UserServiceFeignApiImpl.class)
@LoadBalancerClient(name = "userservice", configuration = UserServiceFeignApiImpl.class)
public interface UserServiceFeignApi {
	
	@PostMapping("/users")
	ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO);
	
	@GetMapping("/users/{user_id}")
	ResponseEntity<UserDTO> getUserByUserId(@PathVariable("user_id") long userId);
	
	@GetMapping("/users")
	ResponseEntity<List<UserDTO>> getAllUsers();
	
	@DeleteMapping("/users/{user_id}")
	ResponseEntity<UserDTO> deleteUser(@PathVariable("user_id") long userId);
	
	@PutMapping("/users/{user_id}")
	ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO, @PathVariable("user_id") long userId );

	@GetMapping("/users/tellmeport")
	public ResponseEntity<String> getUserServicePort();
	
}
