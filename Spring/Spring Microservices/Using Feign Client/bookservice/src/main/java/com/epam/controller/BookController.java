package com.epam.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.epam.dto.BookDTO;
import com.epam.entity.Book;
import com.epam.exception.BookNotFoundException;
import com.epam.service.BookService;

@RestController
public class BookController {

	private ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private BookService bookService;
	
	@PostMapping("/books")
	public ResponseEntity<BookDTO> addBook(@RequestBody BookDTO bookDTO) {
		Book book = modelMapper.map(bookDTO, Book.class);
		Book bookDb = bookService.addBook(book);
		return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(bookDb, BookDTO.class));
	}

	@GetMapping("/books/{book_id}")
	public ResponseEntity<BookDTO> getBook(@PathVariable("book_id") long bookId) throws BookNotFoundException {
		Book book = bookService.getBookById(bookId)
				.orElseThrow(() -> new BookNotFoundException("No book is available having Id " + bookId));
		return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(book, BookDTO.class));
	}

	@GetMapping("/books")
	public ResponseEntity<List<BookDTO>> getAllBook() {
		List<Book> books = bookService.getAllBook();
		List<BookDTO> bookDTOs = books.stream().map(e -> modelMapper.map(e, BookDTO.class))
				.collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(bookDTOs);
	}

	@DeleteMapping("/books/{book_id}")
	public ResponseEntity<BookDTO> deleteBook(@PathVariable("book_id") long bookId) throws BookNotFoundException {
		Book book = bookService.getBookById(bookId)
				.orElseThrow(() -> new BookNotFoundException("No book is available having Id " + bookId));
		bookService.deleteBookById(bookId);
		return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(book, BookDTO.class));
	}

	@PutMapping("books/{book_id}")
	public ResponseEntity<BookDTO> updateBook(@RequestBody BookDTO bookDTO, @PathVariable("book_id") long bookId)
			throws BookNotFoundException {
		System.out.println("hii");
		Book bookDb = bookService.getBookById(bookId)
				.orElseThrow(() -> new BookNotFoundException("No book is available having Id " + bookId));
		bookDb.setName(bookDTO.getName());
		bookDb.setAuthor(bookDTO.getAuthor());
		bookDb.setPublisher(bookDTO.getPublisher());
		Book updatedBook = bookService.updateBook(bookDb);
		return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(updatedBook, BookDTO.class));
	}

}
