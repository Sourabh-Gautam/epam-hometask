package com.epam.microservices.libraryservice.services;

import com.epam.microservices.libraryservice.entity.LibraryEntity;
import com.epam.microservices.libraryservice.repo.LibraryEntityRepo;
import com.epam.microservices.libraryservice.services.api.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private LibraryEntityRepo libraryEntityRepo;

    @Override
    public String issueBook(String username, int bookId) {
        LibraryEntity libraryEntity = new LibraryEntity();
        libraryEntity.setUsername(username);
        libraryEntity.setBookId(bookId);
        libraryEntityRepo.save(libraryEntity);
        return "Book issued successfully to user: " + username;
    }

    @Override
    public String releaseBook(String username, int bookId) {
        Set<LibraryEntity> libraryEntities = libraryEntityRepo.findByUsernameAndBookId(username, bookId);
        if (libraryEntities.isEmpty())
            return "User has not been issued the given book";
        libraryEntityRepo.deleteAll(libraryEntities);
        return "Book has been released successfully";
    }

    @Override
    public String releaseBook(String username) {
        Set<LibraryEntity> libraryEntities = libraryEntityRepo.findByUsername(username);
        System.out.println(libraryEntities);
        if (libraryEntities.isEmpty())
            return ", No book has been issued to this user !";
        libraryEntityRepo.deleteAll(libraryEntities);
        return ", All book issued to this user has been released";
    }

    @Override
    public String releaseBook(int bookId) {
        Set<LibraryEntity> libraryEntities = libraryEntityRepo.findByBookId(bookId);
        if (libraryEntities.isEmpty())
            return ", This book has not been issued to any user";
        libraryEntityRepo.deleteAll(libraryEntities);
        return ", All User who has been issued this book has been released !";
    }

    @Override
    public String fetchUserDetails(String username) {
        Set<LibraryEntity> libraryEntities = libraryEntityRepo.findByUsername(username);
        return libraryEntities.toString();
    }


}
