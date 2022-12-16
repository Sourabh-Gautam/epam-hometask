package com.epam.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.dto.BookDTO;
import com.epam.dto.LibraryDTO;
import com.epam.dto.UserDTO;
import com.epam.entity.Library;
import com.epam.exception.LibraryNotFoundException;
import com.epam.feignapi.BookServiceFeignApi;
import com.epam.feignapi.UserServiceFeignApi;
import com.epam.service.LibraryService;

@RestController
@RequestMapping("/library")
public class LibraryController {

	@Autowired
	private LibraryService libraryService;
	
	@Autowired
	private UserServiceFeignApi userServiceFeignApi;
	
	@Autowired
	private BookServiceFeignApi bookServiceFeignApi;

	private ModelMapper mapper = new ModelMapper();

	@GetMapping("/books")
	public ResponseEntity<List<BookDTO>> getAllBook() {
		return bookServiceFeignApi.getAllBook();
	}

	@GetMapping("/books/{book_id}")
	public ResponseEntity<BookDTO> getBook(@PathVariable("book_id") long bookId) {
		return bookServiceFeignApi.getBook(bookId);
	}

	@PostMapping("/books")
	public ResponseEntity<BookDTO> addBook(@RequestBody BookDTO bookDTO) {
		return bookServiceFeignApi.addBook(bookDTO);
	}

	@PutMapping("/books/{book_id}")
	public ResponseEntity<BookDTO> updateBook(@RequestBody BookDTO bookDTO, @PathVariable("book_id") long bookId) {

		return bookServiceFeignApi.updateBook(bookDTO, bookId);
	}

	@DeleteMapping("/books/{book_id}")
	public ResponseEntity<BookDTO> deleteBook(@PathVariable("book_id") long bookId) {

		return bookServiceFeignApi.deleteBook(bookId);
	}

	@GetMapping("/users")
	public ResponseEntity<List<UserDTO>> getsAllUser() {
		return userServiceFeignApi.getAllUsers();
	}

	@GetMapping("/users/{user_id}")
	public ResponseEntity<UserDTO> getUser(@PathVariable("user_id") long bookId) {
		return userServiceFeignApi.getUserByUserId(bookId);
	}

	@PostMapping("/users")
	public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
		return userServiceFeignApi.addUser(userDTO);
	}

	@PutMapping("/users/{user_id}")
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO, @PathVariable("user_id") long bookId) {

		return userServiceFeignApi.updateUser(userDTO, bookId);
	}

	@DeleteMapping("/users/{user_id}")
	public ResponseEntity<UserDTO> deleteUser(@PathVariable("user_id") long bookId) {

		return userServiceFeignApi.deleteUser(bookId);
	}

	@PostMapping("/users/{username}/books/{book_id}")
	public ResponseEntity<LibraryDTO> issueBook(@PathVariable("username") String username,
			@PathVariable("book_id") long bookId) {

		var library = new Library();
		library.setBookId(bookId);
		library.setUsername(username);
		var libraryDb = libraryService.issueBook(library);

		return ResponseEntity.status(HttpStatus.OK).body(mapper.map(libraryDb, LibraryDTO.class));

	}
	
	@DeleteMapping("/users/{username}/books/{book_id}")
	public ResponseEntity<LibraryDTO> releaseBook(@PathVariable("username") String username,
			@PathVariable("book_id") long bookId) throws LibraryNotFoundException {

		Optional<Library> releaseBook = libraryService.releaseBook(username, bookId);
		
		if(releaseBook.isEmpty()) {
			throw new LibraryNotFoundException("Book didn't issued yet !");
		}

		return ResponseEntity.status(HttpStatus.OK).body(mapper.map(releaseBook.get(), LibraryDTO.class));

	}

}
