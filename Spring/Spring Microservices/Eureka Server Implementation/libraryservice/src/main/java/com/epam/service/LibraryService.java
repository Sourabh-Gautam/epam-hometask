package com.epam.service;

import java.util.Optional;

import com.epam.entity.Library;

public interface LibraryService {

	Library issueBook(Library library);

	Optional<Library> releaseBook(String username, long bookId);
}
