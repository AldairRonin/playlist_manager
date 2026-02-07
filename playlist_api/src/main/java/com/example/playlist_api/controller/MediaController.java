package com.example.playlist_api.controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.playlist_api.dto.MediaCreateDTO;
import com.example.playlist_api.dto.MediaDTO;
import com.example.playlist_api.mapper.MediaMapper;
import com.example.playlist_api.model.Media;
import com.example.playlist_api.model.Podcast;
import com.example.playlist_api.model.Song;
import com.example.playlist_api.service.MediaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/media")
public class MediaController {

    private final MediaService service;

    public MediaController(MediaService service) {
        this.service = service;
    }

    //Получить все media
    @GetMapping
    public List<MediaDTO> getAllMedia() {
        return service.getAllMedia()
                .stream()
                .map(MediaMapper::toDTO)
                .toList();
    }

    //Получить media по ID
    @GetMapping("/{id}")
    public MediaDTO getMediaById(@PathVariable int id) {
        Media media = service.getMediaById(id);
        return MediaMapper.toDTO(media);
    }

    //Создать media через DTO
    @PostMapping
    public MediaDTO createMedia(@Valid @RequestBody MediaCreateDTO dto) {

        Media media;

        if ("song".equalsIgnoreCase(dto.getType())) {
            media = new Song();
        }
        else if ("podcast".equalsIgnoreCase(dto.getType())) {
            media = new Podcast();
        }
        else {
            throw new RuntimeException("Invalid media type");
        }

        media.setTitle(dto.getTitle());
        media.setDuration(dto.getDuration());

        Media saved = service.addMedia(media);

        return MediaMapper.toDTO(saved);
    }

    //Удалить media
    @DeleteMapping("/{id}")
    public void deleteMedia(@PathVariable int id) {
        service.deleteMedia(id);
    }
}
