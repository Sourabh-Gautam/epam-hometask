package com.epam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	enum BooksState {
		NO_BOOKS, SINGLE_COPY, MANY_BOOKS
	}

	@Autowired
	// BookDao bookDao;

	BookRepo repo;

	public BookService() {
	}

	public BookService(BookRepo repo) {
		super();
		this.repo = repo;
	}

	public Book addBook(Book book) {
		return repo.save(book);
	}

	public void updateBook(Book book) {

		Book updatedBook = getBookById(book.getBookId());

		updatedBook.setName(book.getName());
		updatedBook.setNoOfBooksInStock(book.getNoOfBooksInStock());
		updatedBook.setPublisher(book.getPublisher());
		
		
	}

	public List<Book> getBooks() {
		return repo.findAll();
	}

	public Book getBookById(int bookId) {
		return repo.findById(bookId)
				.orElseThrow(() -> new BookNotFoundException("Book Not found Id: " + bookId));
	}

	public List<Book> serachBook(String bookName) {
		List<Book> books = repo.findByName(bookName);
		return books;
	}

	public String sellBook(int bookId) {

		Book book = getBookById(bookId);

		int noOfBooksInStock = book.getNoOfBooksInStock();

		if (noOfBooksInStock >= 1) {

			book.setNoOfBooksInStock(book.getNoOfBooksInStock() - 1);
			updateBook(book);
		}

		return getMessage(noOfBooksInStock);
	}

	public String getMessage(int noOfBooksInStock) {

		Map<Integer, String> booksStatusMessage = new HashMap<>();

		booksStatusMessage.put(0, "No books available in stock.");
		booksStatusMessage.put(1, "Last copy sold Successfully.");
		booksStatusMessage.put(2, "Book sold Successfully.");

		return (noOfBooksInStock >= 2) ? booksStatusMessage.get(2) : booksStatusMessage.get(noOfBooksInStock);
	}

}
