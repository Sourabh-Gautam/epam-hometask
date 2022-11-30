package com.epam.microservices.userservices.services;

import com.epam.microservices.userservices.dto.UserDto;
import com.epam.microservices.userservices.entity.User;
import com.epam.microservices.userservices.exceptions.UserManagementException;
import com.epam.microservices.userservices.repo.UserRepo;
import com.epam.microservices.userservices.services.api.UserService;
import com.epam.microservices.userservices.util.Constants;
import com.epam.microservices.userservices.util.ModelMapperClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public boolean addUser(UserDto userDto) {
        User userToBeSaved = ModelMapperClass.getMapper().map(userDto, User.class);
        if (!userRepo.findAll().contains(userToBeSaved)){
            userRepo.save(userToBeSaved);
            return true;
        }
        return false;
    }

    @Override
    public int removeUser(String username) throws UserManagementException {
        User userToBeRemoved = userRepo.findByUsername(username);
        if(userToBeRemoved != null)
            userRepo.delete(userToBeRemoved);
        else
            throw new UserManagementException(Constants.GIVEN_USER_DOES_NOT_EXISTS);
        return userToBeRemoved.getId();
    }

    @Override
    public UserDto updateUser(String username, UserDto updatedUserDto) throws UserManagementException {
        User userToBeUpdated = userRepo.findByUsername(username);
        if (userToBeUpdated != null) {
            userRepo.updateUserDetails(username, updatedUserDto.getEmail(), updatedUserDto.getName());
            return ModelMapperClass.getMapper().map(userRepo.findByUsername(updatedUserDto.getUsername()), UserDto.class);
        }
        else{
            throw new UserManagementException(Constants.GIVEN_USER_DOES_NOT_EXISTS);
        }

    }

    @Override
    public UserDto getUserByUsername(String username) throws UserManagementException {
        User user = userRepo.findByUsername(username);

        if (user != null)
            return ModelMapperClass.getMapper().map(user, UserDto.class);
        else
            throw new UserManagementException(Constants.GIVEN_USER_DOES_NOT_EXISTS);
    }

    @Override
    public Set<UserDto> getUsers() {
        return userRepo.findAll().stream().map(user -> ModelMapperClass.getMapper().map(user, UserDto.class)).collect(Collectors.toSet());
    }
}
