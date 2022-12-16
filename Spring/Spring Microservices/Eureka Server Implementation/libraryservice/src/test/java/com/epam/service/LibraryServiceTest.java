package com.epam.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.epam.entity.Library;
import com.epam.repo.LibraryRepository;

@SpringBootTest
public class LibraryServiceTest {
	
	@MockBean
	private LibraryRepository libraryRepository;
	
	@Autowired
	LibraryServiceImpl libraryServiceImpl;
	
	@Test
	void issueBookTest() {
		Library library = new Library();
		when(libraryRepository.save(library)).thenReturn(library);
		Library result = libraryServiceImpl.issueBook(library);
		assertThat(result).isEqualTo(library);
	}
	
	@Test
	void releaseBookTest() {
		Library library = new Library();
		library.setBookId(1);
		library.setUsername("Admin");
		when(libraryRepository.findByUsernameAndBookId("Admin", 1)).thenReturn(library);
		doNothing().when(libraryRepository).delete(library);
		Optional<Library> result = libraryServiceImpl.releaseBook("Admin", 1);
		assertThat(result.isPresent()).isTrue();
	}

}
