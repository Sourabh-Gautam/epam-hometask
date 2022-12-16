package com.epam.service;

import java.util.List;
import java.util.Optional;

import com.epam.entity.Book;

public interface BookService {
	Book addBook(Book book);

	Optional<Book> getBookById(long bookId);

	List<Book> getAllBook();

	void deleteBookById(long bookId);

	Book updateBook(Book book);
}
