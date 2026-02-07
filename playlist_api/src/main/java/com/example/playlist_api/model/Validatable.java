package com.example.playlist_api.model;

public interface Validatable {
    void validate(); 
    default boolean isValid() {
        try {
            validate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
