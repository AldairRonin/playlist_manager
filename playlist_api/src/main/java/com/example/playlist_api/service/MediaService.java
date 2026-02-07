package com.example.playlist_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.playlist_api.model.Media;
import com.example.playlist_api.repository.MediaRepository;

@Service
public class MediaService {

    private final MediaRepository mediaRepository;

    public MediaService(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }

    public Media addMedia(Media media) {
        return mediaRepository.save(media);
    }

    public List<Media> getAllMedia() {
        return mediaRepository.findAll();
    }

    public Media getMediaById(int id) {
        return mediaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Media not found"));
    }

    public void deleteMedia(int id) {
        mediaRepository.deleteById(id);
    }
}
