package com.example.playlist_api.mapper;

import java.util.stream.Collectors;

import com.example.playlist_api.dto.PlaylistDTO;
import com.example.playlist_api.model.Playlist;

public class PlaylistMapper {

    public static PlaylistDTO toDTO(Playlist playlist) {

        return new PlaylistDTO(
                playlist.getId(),
                playlist.getName(),
                playlist.getMediaList()
                        .stream()
                        .map(MediaMapper::toDTO)
                        .collect(Collectors.toList())
        );
    }
}
