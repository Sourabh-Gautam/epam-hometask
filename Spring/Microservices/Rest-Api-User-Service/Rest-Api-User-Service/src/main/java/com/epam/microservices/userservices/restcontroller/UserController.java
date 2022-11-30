package com.epam.microservices.userservices.restcontroller;

import com.epam.microservices.userservices.dto.UserDto;
import com.epam.microservices.userservices.exceptions.UserManagementException;
import com.epam.microservices.userservices.services.api.UserService;
import com.epam.microservices.userservices.util.Constants;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<Boolean> addUser(@Valid @RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.addUser(userDto), HttpStatus.CREATED);
    }

    @PutMapping("/{username}")
    public ResponseEntity<UserDto> updateUser(@PathVariable String username,    @Valid @RequestBody UserDto userDto) throws UserManagementException {
        return new ResponseEntity<>(userService.updateUser(username, userDto), HttpStatus.OK);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<String> deleteUser(@PathVariable String username) throws UserManagementException {
        return new ResponseEntity<>(Constants.USER_DELETED_SUCCESSFULLY + userService.removeUser(username), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Set<UserDto>> getUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDto> getUserByUsername(@PathVariable String username) throws UserManagementException {
        return new ResponseEntity<>(userService.getUserByUsername(username), HttpStatus.OK);
    }
}
