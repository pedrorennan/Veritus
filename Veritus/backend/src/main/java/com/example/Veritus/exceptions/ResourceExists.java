package com.example.Veritus.exceptions;

public class ResourceExists extends RuntimeException {
    public ResourceExists(String message) {
        super(message);
    }
}
