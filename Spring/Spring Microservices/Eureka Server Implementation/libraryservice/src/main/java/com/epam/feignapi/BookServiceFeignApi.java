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

import com.epam.dto.BookDTO;

@FeignClient(name = "bookservice", fallback = BookServiceFeignApiImpl.class)
@LoadBalancerClient(name = "bookservice", configuration = BookServiceFeignApiImpl.class)
public interface BookServiceFeignApi {
	
	@GetMapping("/books/tellmeport")
	ResponseEntity<String> getBookServicePort();

	@PostMapping("/books")
	ResponseEntity<BookDTO> addBook(@RequestBody BookDTO bookDTO);
	
	@GetMapping("/books/{book_id}")
	ResponseEntity<BookDTO> getBook(@PathVariable("book_id") long bookId);
	
	@GetMapping("/books")
	ResponseEntity<List<BookDTO>> getAllBook();
	
	@DeleteMapping("/books/{book_id}")
	ResponseEntity<BookDTO> deleteBook(@PathVariable("book_id") long bookId);
	
	@PutMapping("books/{book_id}")
	ResponseEntity<BookDTO> updateBook(@RequestBody BookDTO bookDTO, @PathVariable("book_id") long bookId);

}
