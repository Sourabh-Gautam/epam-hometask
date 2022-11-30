package com.epam.microservices.bookservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

public class BookDto {
    @JsonIgnore
    private int id;

    @NotBlank(message = "name can't be empty")
    private String name;

    @NotBlank(message = "required")
    private String publisher;
    @NotBlank(message = "required")
    private String author;

    public BookDto() {
    }

    public BookDto(int id, String name, String publisher, String author) {
        this.id = id;
        this.name = name;
        this.publisher = publisher;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", publisher='" + publisher + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDto bookDto = (BookDto) o;
        return getId() == bookDto.getId() && getName().equals(bookDto.getName()) && getPublisher().equals(bookDto.getPublisher()) && getAuthor().equals(bookDto.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPublisher(), getAuthor());
    }
}
