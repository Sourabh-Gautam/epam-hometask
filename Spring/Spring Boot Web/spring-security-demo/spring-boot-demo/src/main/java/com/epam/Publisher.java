package com.epam;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Publisher {

	@Id
	private String code;

	private String name;
	
	@OneToOne(mappedBy = "publisher")
	private Book book;

	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}


	public Publisher() {
	}
	

	public Publisher(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}



	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Publisher [code=" + code + ", name=" + name + "]";
	}

}
