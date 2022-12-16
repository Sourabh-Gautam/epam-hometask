package com.epam.service;

import java.util.List;
import java.util.Optional;

import com.epam.entity.User;

public interface UserService {

	User addUser(User user);

	Optional<User> getUserByUserId(long userId);

	List<User> getAllUsers();

	void deleteBookByUserId(long userId);

	User updateUserByUserId(User user);

//	List<User> getAllBook();
//
//	void deleteBookById(long bookId);
//
//	User updateBook(User book);

}
