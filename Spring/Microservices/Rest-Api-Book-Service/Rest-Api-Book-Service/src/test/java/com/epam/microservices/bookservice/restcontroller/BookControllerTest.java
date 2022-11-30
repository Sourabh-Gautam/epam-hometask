package com.epam.microservices.bookservice.restcontroller;

import com.epam.microservices.bookservice.dto.BookDto;
import com.epam.microservices.bookservice.entity.Book;
import com.epam.microservices.bookservice.exception.BookManagementException;
import com.epam.microservices.bookservice.service.api.BookService;
import com.epam.microservices.bookservice.util.Constant;
import com.epam.microservices.bookservice.util.ModelMapperClass;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = BookController.class)
class BookControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    @Autowired
    private BookService bookService;

    private BookDto bookDto;
    private BookDto newBookDto;
    private Book book;
    private String requestBody;

    @BeforeEach
    void init() throws JsonProcessingException {
        bookDto = new BookDto(1, "Intro to Java", "TMH", "J. Block");

        newBookDto = new BookDto();
        newBookDto.setName("Intro to Java");
        newBookDto.setPublisher("TMH");
        newBookDto.setAuthor("J. Block");

        book = ModelMapperClass.getMapper().map(bookDto, Book.class);
        requestBody = objectMapper.writeValueAsString(newBookDto);
    }

    @Test
    void addBookMethodTest() throws Exception {
        when(bookService.addBook(newBookDto)).thenReturn(newBookDto);
        mockMvc.perform(post("/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpectAll(
                        status().isCreated(),
                        content().string(String.valueOf(requestBody))
                );

    }

    @Test
    void updateBookMethodTest() throws Exception {
        when(bookService.updateBook(1, newBookDto)).thenReturn(newBookDto);
        mockMvc.perform(put("/books/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpectAll(
                        status().isOk(),
                        content().string(objectMapper.writeValueAsString(newBookDto))
                );

    }

}
