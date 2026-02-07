package com.example.playlist_api.mapper;

import com.example.playlist_api.dto.MediaDTO;
import com.example.playlist_api.model.Media;

public class MediaMapper {

    public static MediaDTO toDTO(Media media) {
        return new MediaDTO(
                media.getId(),
                media.getTitle(),
                media.getDuration()
        );
    }
}
