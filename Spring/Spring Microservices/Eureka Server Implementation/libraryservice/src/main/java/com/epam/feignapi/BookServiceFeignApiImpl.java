package com.epam.feignapi;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.epam.dto.BookDTO;

@Service
public class BookServiceFeignApiImpl implements BookServiceFeignApi {

	private BookDTO fallback = new BookDTO();
	
	@Override
	public ResponseEntity<String> getBookServicePort() {
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("fallback");
	}

	@Override
	public ResponseEntity<BookDTO> addBook(BookDTO bookDTO) {
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(bookDTO);
	}

	@Override
	public ResponseEntity<BookDTO> getBook(long bookId) {
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(fallback);
	}

	@Override
	public ResponseEntity<List<BookDTO>> getAllBook() {
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(List.of(fallback));
	}

	@Override
	public ResponseEntity<BookDTO> deleteBook(long bookId) {
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(fallback);
	}

	@Override
	public ResponseEntity<BookDTO> updateBook(BookDTO bookDTO, long bookId) {
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(fallback);
	}

}
