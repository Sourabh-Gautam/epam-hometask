package com.epam;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService service;

	@RequestMapping("/welcome")
	public String loadWelcomeMessage() {
		return "<h1>Welcome to Online Book Store</h1>";
	}

	@GetMapping("/loadbook")
	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	public ModelAndView loadAddBookPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("createBook");
		return mv;

	}

	@PostMapping("/addbook")
	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	public ModelAndView addBook(@Valid Book book, BindingResult result) {

		ModelAndView mv = new ModelAndView();

		if (!result.hasErrors()) {

			book = service.addBook(book);

			if (book.getBookId() > 0) {
				mv.addObject("msg", "Book Added Successfully.");
				mv.setViewName("success");
			}
		} else {
			mv.setViewName("createBook");
		}

		return mv;

	}

	@GetMapping
	@PreAuthorize(value = "hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	public ModelAndView loadBooks() {
		ModelAndView mv = new ModelAndView();
		List<Book> books = service.getBooks();
		mv.addObject("books", books);
		mv.setViewName("books");
		return mv;
	}

	// http://localhost:8080/books?bookName=SpringMVC
	@GetMapping("/searchbook")
	public ModelAndView searchBook(@RequestParam("bookName") String bookName) {
		ModelAndView mv = new ModelAndView();
		List<Book> books = service.serachBook(bookName);
		mv.addObject("books", books);
		mv.setViewName("books");
		return mv;
	}

	// http://localhost:8080/books/{bookid}
	@GetMapping("/{bookid}")
	public ModelAndView searchBookUsingPathVariable(@PathVariable("bookid") int bookId) {
		ModelAndView mv = new ModelAndView();
		Book book = service.getBookById(bookId);
		mv.addObject("book", book);
		mv.setViewName("viewBook");
		return mv;
	}

}
