package com.epam;

public class App {
	public static void main(String[] args) {

		BookDao dao = new BookDao();

		Book book = new Book();
		book.setIsbn("abcd1234");
		book.setName("Spring MVC with Reactive");

		dao.insert(book);
		
		System.out.println(dao.get(2));
		
		
	}
}
