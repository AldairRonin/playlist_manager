package com.example.playlist_api.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {

        super(message);
    }
    
}
