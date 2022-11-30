package com.epam.microservices.bookservice.repo;

import com.epam.microservices.bookservice.entity.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE Book b SET b.name = :name, b.publisher = :publisher, b.author = :author WHERE b.id = :bookId")
    int updateBookDetails(int bookId, String name, String publisher, String author);
}
