package com.epam.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.entity.Library;


public interface LibraryRepository extends JpaRepository<Library, Long> {

	Library findByUsernameAndBookId(String username, long bookId);

}
