package com.epam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.entity.Book;
import com.epam.repo.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book addBook(Book book) {

		return bookRepository.save(book);
	}

	@Override
	public Optional<Book> getBookById(long bookId) {
		return bookRepository.findById(bookId);
	}

	@Override
	public List<Book> getAllBook() {
		return bookRepository.findAll();
	}

	@Override
	public void deleteBookById(long bookId) {
		bookRepository.deleteById(bookId);
	}

	@Override
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}

}
