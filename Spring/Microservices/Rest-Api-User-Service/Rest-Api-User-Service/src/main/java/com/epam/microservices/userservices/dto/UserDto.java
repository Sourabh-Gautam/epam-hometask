package com.epam.microservices.userservices.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

public class UserDto {

    private int id;
    @NotBlank(message = "username can't be empty")
    private String username;

    @NotBlank(message = "Required")
    private String email;

    @NotBlank(message = "Required")
    private String name;

    public UserDto() {
    }

    public UserDto(String username, String email, String name) {
        this.username = username;
        this.email = email;
        this.name = name;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return getUsername().equals(userDto.getUsername()) && getEmail().equals(userDto.getEmail()) && getName().equals(userDto.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername(), getEmail(), getName());
    }
}

