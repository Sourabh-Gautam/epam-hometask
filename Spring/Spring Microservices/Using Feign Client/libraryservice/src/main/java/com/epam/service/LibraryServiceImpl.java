package com.epam.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.entity.Library;
import com.epam.repo.LibraryRepository;

@Service
public class LibraryServiceImpl implements LibraryService {

	@Autowired
	private LibraryRepository libraryRepository;

	@Override
	public Library issueBook(Library library) {
		return libraryRepository.save(library);
	}

	@Override
	public Optional<Library> releaseBook(String username, long bookId) {
		Library library = libraryRepository.findByUsernameAndBookId(username, bookId);
		Optional<Library> optional = Optional.empty();
		if(library!=null) {
			optional = Optional.ofNullable(library);
			libraryRepository.delete(library);
		}
		return optional;
	}

}
