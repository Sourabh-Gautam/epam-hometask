package com.epam.microservices.userservices.services.api;

import com.epam.microservices.userservices.dto.UserDto;
import com.epam.microservices.userservices.exceptions.UserManagementException;

import java.util.Set;

public interface UserService {
    boolean addUser(UserDto userDto);
    int removeUser(String username) throws UserManagementException;
    UserDto updateUser(String username, UserDto updatedUserDto) throws UserManagementException;
    UserDto getUserByUsername(String username) throws UserManagementException;
    Set<UserDto> getUsers();
}
