package com.example.Veritus.exceptions;

public class UserExists extends RuntimeException {
    public UserExists(String message) {
        super(message);
    }
}
