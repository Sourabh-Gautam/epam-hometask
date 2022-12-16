package com.epam.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.epam.dto.BookDTO;
import com.epam.feignapi.BookServiceFeignApi;
import com.epam.feignapi.UserServiceFeignApi;
import com.epam.service.LibraryService;

@WebMvcTest(controllers = LibraryController.class)
public class LibraryControllerTest {

	@MockBean
	private LibraryService libraryService;
	
	@MockBean
	private UserServiceFeignApi userServiceFeignApi;
	
	@MockBean
	private BookServiceFeignApi bookServiceFeignApi;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void getAllBookTest() throws Exception {
		when(bookServiceFeignApi.getAllBook()).thenReturn(ResponseEntity.status(HttpStatus.OK).body(null));
		mockMvc.perform(get("/library/books").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	
	@Test
	void getBookTest() throws Exception {
		when(bookServiceFeignApi.getBook(1)).thenReturn(ResponseEntity.status(HttpStatus.OK).body(null));
		mockMvc.perform(get("/library/books/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	
	@Test
	void addBookTest() throws Exception {
		BookDTO bookDTO = new BookDTO();
		when(bookServiceFeignApi.addBook(bookDTO)).thenReturn(ResponseEntity.status(HttpStatus.OK).body(null));
		mockMvc.perform(post("/library/books").contentType(MediaType.APPLICATION_JSON).content("{}")).andExpect(status().isOk());
	}
	
	@Test
	void updateBookTest() throws Exception {
		BookDTO bookDTO = new BookDTO();
		when(bookServiceFeignApi.updateBook(bookDTO, 1)).thenReturn(ResponseEntity.status(HttpStatus.OK).body(null));
		mockMvc.perform(put("/library/books/1").contentType(MediaType.APPLICATION_JSON).content("{}")).andExpect(status().isOk());
	}
	
	@Test
	void deleteBookTest() throws Exception {
		when(bookServiceFeignApi.deleteBook(1)).thenReturn(ResponseEntity.status(HttpStatus.OK).body(null));
		mockMvc.perform(delete("/library/books/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	
}
