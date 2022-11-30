package com.epam.microservices.bookservice.service;

import com.epam.microservices.bookservice.dto.BookDto;
import com.epam.microservices.bookservice.entity.Book;
import com.epam.microservices.bookservice.exception.BookManagementException;
import com.epam.microservices.bookservice.repo.BookRepo;
import com.epam.microservices.bookservice.util.ModelMapperClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {
    @InjectMocks
    private BookServiceImpl bookServiceImpl;

    @Mock
    private BookRepo bookRepo;

    private BookDto bookDto;
    private BookDto newBookDto;
    private Book book;

    @BeforeEach
    void init() {
        bookDto = new BookDto(1, "Intro to Java", "TMH", "J. Block");
        newBookDto = new BookDto(2, "Servlets & Jsp", "Pearson", "Baker Hughes");
        book = ModelMapperClass.getMapper().map(bookDto, Book.class);
    }

    @Test
    void addBookMethodTest() {
        Book book = ModelMapperClass.getMapper().map(bookDto, Book.class);
        when(bookRepo.save(book)).thenReturn(book);
        assertEquals(bookDto, bookServiceImpl.addBook(bookDto));

    }

    @Test
    void updateBookMethodTest() throws BookManagementException {
        BookDto updatedBookDto = new BookDto(1, "Intro to Spring", "Lilly", "R Swammy");
        when(bookRepo.existsById(1)).thenReturn(true);
        when(bookRepo.updateBookDetails(1, updatedBookDto.getName(), updatedBookDto.getPublisher(), updatedBookDto.getAuthor())).thenReturn(1);
        when(bookRepo.findById(1)).thenReturn(Optional.of(ModelMapperClass.getMapper().map(updatedBookDto, Book.class)));
        assertEquals(updatedBookDto, bookServiceImpl.updateBook(1, updatedBookDto));

        when(bookRepo.existsById(1)).thenReturn(false);
        assertThrows(BookManagementException.class, () -> bookServiceImpl.updateBook(1, updatedBookDto));

    }

    @Test
    void deleteBookMethodTest() throws BookManagementException {
        when(bookRepo.existsById(1)).thenReturn(true);
        when(bookRepo.findById(1)).thenReturn(Optional.of(book));
        assertEquals(1, bookServiceImpl.deleteBook(1));

        when(bookRepo.existsById(1)).thenReturn(false);
        assertThrows(BookManagementException.class, () -> bookServiceImpl.deleteBook(1));
    }

    @Test
    void getBookByIdMethodTest() throws BookManagementException {
        when(bookRepo.existsById(1)).thenReturn(true);
        when(bookRepo.findById(1)).thenReturn(Optional.of(book));
        assertEquals(bookDto, bookServiceImpl.getBookById(1));

        when(bookRepo.existsById(1)).thenReturn(false);
        assertThrows(BookManagementException.class, () -> bookServiceImpl.getBookById(1));
    }

    @Test
    void getBooksMethodTest() throws BookManagementException {
        when(bookRepo.count()).thenReturn(1L);
        when(bookRepo.findAll()).thenReturn(Collections.singletonList(book));
        assertEquals(new HashSet<>(Collections.singletonList(bookDto)), bookServiceImpl.getBooks());

        when(bookRepo.count()).thenReturn(0L);
        assertThrows(BookManagementException.class, () -> bookServiceImpl.getBooks());

    }

}
