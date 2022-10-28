package com.epam;


public class App {
	public static void main(String[] args) {

		BookDao dao = new BookDao();

//		Book book = new Book();
//		book.setIsbn("abcd1234");
//		book.setName("Spring MVC with Reactive");
//
//		dao.insert(book);
		
//		System.out.println(dao.get(1));
		
		Book book = new Book();
		book.setBookId(1);
		book.setIsbn("abcd1234");
		book.setName("Spring MVC");
		
		dao.update(book);
		
	}
}
