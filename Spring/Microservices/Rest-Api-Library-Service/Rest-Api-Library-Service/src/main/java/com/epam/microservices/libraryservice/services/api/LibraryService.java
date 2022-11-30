package com.epam.microservices.libraryservice.services.api;

public interface LibraryService {
    String issueBook(String username, int bookId);
    String releaseBook(String username, int bookId);

    String releaseBook(String username);
    String releaseBook(int bookId);

    String fetchUserDetails(String username);

}
