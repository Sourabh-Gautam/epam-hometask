package com.epam.controller;

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
import org.springframework.web.reactive.function.client.WebClient;

import com.epam.dto.BookDTO;
import com.epam.dto.LibraryDTO;
import com.epam.dto.UserDTO;
import com.epam.entity.Library;
import com.epam.exception.LibraryNotFoundException;
import com.epam.service.LibraryService;

import jakarta.annotation.Resource;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/library")
public class LibraryController {

	@Resource(name = "getUserWebClient")
	private WebClient userWebClient;

	@Resource(name = "getBookWebClient")
	private WebClient bookWebClient;

	@Autowired
	private LibraryService libraryService;

	private ModelMapper mapper = new ModelMapper();

	@GetMapping("/books")
	public Mono<String> getAllBook() {
		return bookWebClient.get().uri("/books").retrieve().bodyToMono(String.class);
	}

	@GetMapping("/books/{book_id}")
	public Mono<String> getBook(@PathVariable("book_id") long bookId) {
		return bookWebClient.get().uri("/books/{book_id}", bookId).retrieve().bodyToMono(String.class);
	}

	@PostMapping("/books")
	public Mono<String> addBook(@RequestBody BookDTO bookDTO) {
		return bookWebClient.post().uri("/books").bodyValue(bookDTO).retrieve().bodyToMono(String.class);
	}

	@PutMapping("/books/{book_id}")
	public Mono<String> updateBook(@RequestBody BookDTO bookDTO, @PathVariable("book_id") long bookId) {

		return bookWebClient.put().uri("/books/{book_id}", bookId).bodyValue(bookDTO).retrieve()
				.bodyToMono(String.class);
	}

	@DeleteMapping("/books/{book_id}")
	public Mono<String> deleteBook(@PathVariable("book_id") long bookId) {

		return bookWebClient.delete().uri("/books/{book_id}", bookId).retrieve().bodyToMono(String.class);
	}

	@GetMapping("/users")
	public Mono<String> getAllUser() {
		return userWebClient.get().uri("/users").retrieve().bodyToMono(String.class);
	}

	@GetMapping("/users/{user_id}")
	public Mono<String> getUser(@PathVariable("user_id") long bookId) {
		return userWebClient.get().uri("/users/{user_id}", bookId).retrieve().bodyToMono(String.class);
	}

	@PostMapping("/users")
	public Mono<String> addUser(@RequestBody UserDTO userDTO) {
		return userWebClient.post().uri("/users").bodyValue(userDTO).retrieve().bodyToMono(String.class);
	}

	@PutMapping("/users/{user_id}")
	public Mono<String> updateUser(@RequestBody UserDTO userDTO, @PathVariable("user_id") long bookId) {

		return userWebClient.put().uri("/users/{user_id}", bookId).bodyValue(userDTO).retrieve()
				.bodyToMono(String.class);
	}

	@DeleteMapping("/users/{user_id}")
	public Mono<String> deleteUser(@PathVariable("user_id") long bookId) {

		return userWebClient.delete().uri("/users/{user_id}", bookId).retrieve().bodyToMono(String.class);
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
	
//	@DeleteMapping("/users/{username}")
//	public R

}
