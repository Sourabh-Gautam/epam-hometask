package com.epam.microservices.bookservice.service.api;

import com.epam.microservices.bookservice.dto.BookDto;
import com.epam.microservices.bookservice.exception.BookManagementException;

import java.util.Set;

public interface BookService {
    BookDto addBook(BookDto bookDto);
    BookDto updateBook(int bookId, BookDto updatedBookDto) throws BookManagementException;
    int deleteBook(int bookId) throws BookManagementException;
    BookDto getBookById(int bookId) throws BookManagementException;
    Set<BookDto> getBooks() throws BookManagementException;
}
