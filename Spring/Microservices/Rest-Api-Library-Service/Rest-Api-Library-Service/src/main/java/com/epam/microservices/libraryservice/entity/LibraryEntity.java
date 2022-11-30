package com.epam.microservices.libraryservice.entity;

import jakarta.persistence.*;

import java.util.Objects;
@Entity
@Table(name = "library_table")
public class LibraryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    private int bookId;

    public LibraryEntity() {
    }

    public LibraryEntity(int id, String username, int bookId) {
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
        return "LibraryEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", bookId=" + bookId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LibraryEntity that = (LibraryEntity) o;
        return getId() == that.getId() && getBookId() == that.getBookId() && getUsername().equals(that.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getBookId());
    }
}
