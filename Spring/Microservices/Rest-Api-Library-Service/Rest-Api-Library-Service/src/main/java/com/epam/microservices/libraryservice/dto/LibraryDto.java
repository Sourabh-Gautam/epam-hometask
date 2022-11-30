package com.epam.microservices.libraryservice.dto;

import java.util.Objects;

public class LibraryDto {
    private int id;

    private String username;

    private int bookId;

    public LibraryDto() {
    }

    public LibraryDto(int id, String username, int bookId) {
        this.id = id;
        this.username = username;
        this.bookId = bookId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "LibraryDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", bookId=" + bookId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LibraryDto that = (LibraryDto) o;
        return getId() == that.getId() && getBookId() == that.getBookId() && getUsername().equals(that.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getBookId());
    }
}
