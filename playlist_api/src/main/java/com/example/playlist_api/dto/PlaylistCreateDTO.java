package com.example.playlist_api.dto;

import jakarta.validation.constraints.NotBlank;

public class PlaylistCreateDTO {

    @NotBlank(message = "Playlist name cannot be empty")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
