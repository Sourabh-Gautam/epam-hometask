package com.epam.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.entity.Book;


public interface BookRepository extends JpaRepository<Book, Long> {

	
}
