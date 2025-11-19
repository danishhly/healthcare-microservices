package com.example.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resourceName, Object identifier) {
        super(String.format("%s with id %s was not found", resourceName, identifier));
    }
}