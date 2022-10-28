package com.epam;

import java.util.ArrayList;
import java.util.List;

public class App {
	public static void main(String[] args) {

		BookDao dao = new BookDao();
		
		Publisher publisher = new Publisher("MANN", "Manning Publications Co.");

		Book book = new Book();
		book.setIsbn("abcd1234");
		book.setName("Spring Data");
		book.setPublisher(publisher);

		List<Chapter> chapters = new ArrayList<>();

		Chapter chapter1 = new Chapter();
		chapter1.setChapterTitle("Spring Data Family.");
		

		Chapter chapter2 = new Chapter();
		chapter2.setChapterTitle("Spring Data Commons.");
		

		chapters.add(chapter1);
		chapters.add(chapter2);
		
		book.setChapters(chapters);

		dao.insert(book);
//
//		System.out.println(dao.get(2));
		
//		List<Book> books = dao.getBooks();
//
//		System.out.println(books);
		//books.forEach(book->System.out.println(book.getChapters()));

		

	}
}
