package com.epam.microservices.bookservice.service;

import com.epam.microservices.bookservice.dto.BookDto;
import com.epam.microservices.bookservice.entity.Book;
import com.epam.microservices.bookservice.exception.BookManagementException;
import com.epam.microservices.bookservice.repo.BookRepo;
import com.epam.microservices.bookservice.service.api.BookService;
import com.epam.microservices.bookservice.util.Constant;
import com.epam.microservices.bookservice.util.ModelMapperClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepo bookRepo;
    @Override
    public BookDto addBook(BookDto bookDto) {
        Book newBook = ModelMapperClass.getMapper().map(bookDto, Book.class);
        return ModelMapperClass.getMapper().map(bookRepo.save(newBook), BookDto.class);

    }

    @Override
    public BookDto updateBook(int bookId, BookDto updatedBookDto) throws BookManagementException {
        if(bookRepo.existsById(bookId)) {
           bookRepo.updateBookDetails(bookId, updatedBookDto.getName(), updatedBookDto.getPublisher(), updatedBookDto.getAuthor());
           return ModelMapperClass.getMapper().map(bookRepo.findById(bookId), BookDto.class);
        }
        else
            throw new BookManagementException(Constant.GIVEN_BOOK_DOES_NOT_EXISTS);

    }

    @Override
    public int deleteBook(int bookId) throws BookManagementException {
        if (bookRepo.existsById(bookId)){
            bookRepo.delete(bookRepo.findById(bookId).get());
            return  bookId;
        }
        else
            throw new BookManagementException(Constant.GIVEN_BOOK_DOES_NOT_EXISTS);

    }

    @Override
    public BookDto getBookById(int bookId) throws BookManagementException {
        if (bookRepo.existsById(bookId))
            return ModelMapperClass.getMapper().map(bookRepo.findById(bookId).get(), BookDto.class);
        else
            throw new BookManagementException(Constant.GIVEN_BOOK_DOES_NOT_EXISTS);
    }

    @Override
    public Set<BookDto> getBooks() throws BookManagementException {
        if (bookRepo.count() > 0)
            return bookRepo.findAll().stream().map(book -> ModelMapperClass.getMapper().map(book, BookDto.class)).collect(Collectors.toSet());
        else
            throw new BookManagementException(Constant.BOOK_COUNT_ZERO);
    }
}
