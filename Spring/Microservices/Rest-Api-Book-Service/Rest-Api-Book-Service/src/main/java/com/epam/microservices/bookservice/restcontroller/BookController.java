package com.epam.microservices.bookservice.restcontroller;

import com.epam.microservices.bookservice.dto.BookDto;
import com.epam.microservices.bookservice.exception.BookManagementException;
import com.epam.microservices.bookservice.service.api.BookService;
import com.epam.microservices.bookservice.util.Constant;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping()
    public ResponseEntity<BookDto> addBook(@Valid @RequestBody BookDto bookDto){
        return new ResponseEntity<>(bookService.addBook(bookDto), HttpStatus.CREATED);
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<BookDto> updateBook(@PathVariable int bookId, @Valid @RequestBody BookDto bookDto) throws BookManagementException {
        return new ResponseEntity<>(bookService.updateBook(bookId, bookDto), HttpStatus.OK);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable int bookId) throws BookManagementException {
        return new ResponseEntity<>(Constant.BOOK_DELETED_SUCCESSFULLY  + bookService.deleteBook(bookId), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Set<BookDto>> getBooks() throws BookManagementException {
        return new ResponseEntity<>(bookService.getBooks(), HttpStatus.OK);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookDto> getBookById(@PathVariable int bookId) throws BookManagementException {
        return new ResponseEntity<>(bookService.getBookById(bookId), HttpStatus.OK);
    }

}
