package com.example.playlist_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class MediaCreateDTO {

    @NotBlank(message = "Title cannot be empty")
    private String title;

    @Positive(message = "Duration must be greater than 0")
    private int duration;

    @NotBlank(message = "Type must be specified")
    private String type;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
