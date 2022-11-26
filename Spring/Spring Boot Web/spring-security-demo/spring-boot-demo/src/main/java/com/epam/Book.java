package com.epam;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
//@Table(name="tbl_book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @Column(name="book_id")
	private int bookId;

	@NotBlank(message = "Please enter book isbn.")
	private String isbn;

	@Column
	private String name;

	@Min(value = 1, message = "Book price shuld be greater than zero.")
	private Double price;

	@Min(value = 5, message = "Books in stock in should be greater than 5.")
	private int noOfBooksInStock;

	public int getNoOfBooksInStock() {
		return noOfBooksInStock;
	}

	public void setNoOfBooksInStock(int noOfBooksInStock) {
		this.noOfBooksInStock = noOfBooksInStock;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "book", fetch = FetchType.EAGER)
	private List<Chapter> chapters;

	@OneToOne(cascade = CascadeType.ALL)
	private Publisher publisher;

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		publisher.setBook(this);
		this.publisher = publisher;
	}

	public List<Chapter> getChapters() {
		return chapters;
	}

	public void setChapters(List<Chapter> chapters) {
		chapters.forEach(chapter -> chapter.setBook(this));
		this.chapters = chapters;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public Book() {
	}

	public Book(String isbn, String name) {
		super();
		this.isbn = isbn;
		this.name = name;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", isbn=" + isbn + ", name=" + name + ", price=" + price
				+ ", noOfBooksInStock=" + noOfBooksInStock + "]";
	}

}
