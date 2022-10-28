package com.epam;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class BookDao {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-persistence-unit");

	public void insert(Book book) {

		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();

		manager.persist(book);

		manager.getTransaction().commit();

		manager.close();

	}

	public Book get(int bookId) {
		EntityManager manager = factory.createEntityManager();
		Book book = manager.find(Book.class, bookId);
		manager.close();
		return book;
	}

	public Book update(Book book) {
		EntityManager manager = factory.createEntityManager();

		Book updateBook = manager.find(Book.class, book.getBookId());
		if (updateBook == null) {
			throw new BookNotFoundException("Book is not available with id : " + book.getBookId());
		}
		manager.getTransaction().begin();
		updateBook.setIsbn(book.getIsbn());
		updateBook.setName(book.getName());
		manager.getTransaction().commit();

		manager.close();
		return book;
	}

	public Book delete(int bookId) {
		EntityManager manager = factory.createEntityManager();

		Book book = manager.find(Book.class, bookId);
		if (book == null) {
			throw new BookNotFoundException("Book is not available with id : " + book.getBookId());
		}
		manager.getTransaction().begin();
		manager.remove(book);
		manager.getTransaction().commit();

		manager.close();
		return book;
	}

}
