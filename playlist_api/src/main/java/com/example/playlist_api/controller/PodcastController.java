package com.example.playlist_api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.playlist_api.model.Podcast;
import com.example.playlist_api.service.MediaService;

@RestController
@RequestMapping("/podcasts")
public class PodcastController {

    private final MediaService mediaService;

    public PodcastController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    @PostMapping
    public Podcast createPodcast(@RequestBody Podcast podcast) {
        return (Podcast) mediaService.addMedia(podcast);
    }
}
