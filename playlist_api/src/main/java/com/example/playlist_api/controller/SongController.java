package com.example.playlist_api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.playlist_api.model.Song;
import com.example.playlist_api.service.MediaService;

@RestController
@RequestMapping("/songs")
public class SongController {

    private final MediaService mediaService;

    public SongController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    @PostMapping
    public Song createSong(@RequestBody Song song) {
        return (Song) mediaService.addMedia(song);
    }
}
