package com.epam.microservices.libraryservice.restcontroller;

import com.epam.microservices.libraryservice.dto.BookDto;
import com.epam.microservices.libraryservice.dto.UserDto;
import com.epam.microservices.libraryservice.services.api.LibraryService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/library")
public class LibraryController {
    Logger LOGGER = LogManager.getLogger(LibraryController.class);
    @Autowired
    private LibraryService libraryService;
    @Resource(name = "getUserWebClient")
    private WebClient userWebClient;

    @Resource(name = "getBookWebClient")
    private WebClient bookWebClient;

    @GetMapping()
    public Flux<String> getBooks() {
        return bookWebClient.get()
                .uri("")
                .retrieve()
                .bodyToFlux(String.class);
    }

    @GetMapping("/{bookId}")
    public Mono<BookDto> getBookById(@PathVariable int bookId){
        return bookWebClient.get()
                .uri("/{bookId}", bookId)
                .retrieve()
                .bodyToMono(BookDto.class);
    }

    @PostMapping()
    public Mono<BookDto> addBook(@Valid @RequestBody BookDto bookDto){
        return bookWebClient.post()
                .uri("")
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(bookDto)
                .retrieve()
                .bodyToMono(BookDto.class);
    }

    @PutMapping("/{bookId}")
    public Mono<BookDto> updateBook(@PathVariable int bookId, @Valid @RequestBody BookDto bookDto) {
        return bookWebClient.put()
                .uri("/{bookId}", bookId)
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(bookDto)
                .retrieve()
                .bodyToMono(BookDto.class);
    }

    @DeleteMapping("/{bookId}")
    public Flux<String> deleteBook(@PathVariable int bookId) {
        //remove association b/w book n user from library table
        Mono<String> mono = Mono.just(libraryService.releaseBook(bookId));
        return bookWebClient.delete()
                .uri("/{bookId}", bookId)
                .retrieve()
                .bodyToMono(String.class)
                .concatWith(mono);
    }


    @GetMapping("/users")
    public Flux<String> getUsers() {
        return userWebClient.get()
                .uri("")
                .retrieve()
                .bodyToFlux(String.class);
    }

    @GetMapping("/users/{username}")
    public Flux<String> getUserByUsername(@PathVariable String username) {
        //view user profile with issued books
        LOGGER.info(libraryService.fetchUserDetails(username));
        return userWebClient.get()
                .uri("/{username}", username)
                .retrieve()
                .bodyToMono(String.class)
                .concatWith(Mono.just("\n" + libraryService.fetchUserDetails(username)));

    }

    @PostMapping("/users")
    public Mono<Boolean> addUser(@Valid @RequestBody UserDto userDto) {
        return userWebClient.post()
                .uri("")
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(userDto)
                .retrieve()
                .bodyToMono(Boolean.class);

    }

    @PutMapping("/users/{username}")
    public Mono<UserDto> updateUser(@PathVariable String username, @Valid @RequestBody UserDto userDto) {
        return userWebClient.put()
                .uri("/{username}", username)
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(userDto)
                .retrieve()
                .bodyToMono(UserDto.class);
    }

    @DeleteMapping("/users/{username}")
    public Flux<String> deleteUser(@PathVariable String username) {
        //remove association between username and book
        Mono<String> mono = Mono.just(libraryService.releaseBook(username));
        return userWebClient.delete()
                .uri("/{username}", username)
                .retrieve()
                .bodyToMono(String.class)
                .concatWith(mono);
    }

    @PostMapping("/issueBook/{username}/{bookId}")
    public ResponseEntity<String> issueBook(@PathVariable String username, @PathVariable  int bookId) {
        Flux<String> fluxUser = getUserByUsername(username);
        Mono<BookDto> monoBook = getBookById(bookId);

        if (fluxUser.blockFirst() != null && monoBook.block() != null)
            return new ResponseEntity<>(libraryService.issueBook(username, bookId), HttpStatus.OK);
        return new ResponseEntity<>("Either user or book doesn't exists !", HttpStatus.OK);
    }

    @DeleteMapping("/releaseBook/{username}/{bookId}")
    public ResponseEntity<String> releaseBook(@PathVariable String username, @PathVariable int bookId) {
        return new ResponseEntity<>(libraryService.releaseBook(username, bookId), HttpStatus.OK);
    }



}
