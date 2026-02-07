package com.example.playlist_api.controller;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.playlist_api.dto.MediaDTO;
import com.example.playlist_api.dto.PlaylistCreateDTO;
import com.example.playlist_api.dto.PlaylistDTO;
import com.example.playlist_api.mapper.MediaMapper;
import com.example.playlist_api.mapper.PlaylistMapper;
import com.example.playlist_api.model.Media;
import com.example.playlist_api.model.Playlist;
import com.example.playlist_api.service.MediaService;
import com.example.playlist_api.service.PlaylistService;


@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    private final PlaylistService playlistService;
    private final MediaService mediaService;


    public PlaylistController(PlaylistService playlistService, MediaService mediaService) {
        this.playlistService = playlistService;
        this.mediaService = mediaService;
    }

    @PostMapping
    public PlaylistDTO createPlaylist(@RequestBody PlaylistCreateDTO dto) {
        Playlist playlist = playlistService.createPlaylist(dto.getName());
        return PlaylistMapper.toDTO(playlist);
    }


    @GetMapping("/{id}/media")
    public List<MediaDTO> getPlaylistMedia(@PathVariable int id) {
        return playlistService.getPlaylistMedia(id)
            .stream()
            .map(MediaMapper::toDTO)
            .toList();
    }


    @GetMapping
    public List<PlaylistDTO> getAllPlaylists() {
        return playlistService.getAllPlaylists()
                .stream()
                .map(PlaylistMapper::toDTO)
                .toList();
    }


    @PostMapping("/{playlistId}/media/{mediaId}")
    public void addMediaToPlaylist(
        @PathVariable int playlistId,
        @PathVariable int mediaId) {

    Media media = mediaService.getMediaById(mediaId);
    playlistService.addMediaToPlaylist(playlistId, media);
    }


    @DeleteMapping("/{playlistId}/media/{mediaId}")
    public void removeMediaFromPlaylist(
        @PathVariable int playlistId,
        @PathVariable int mediaId) {

    Media media = mediaService.getMediaById(mediaId);
    playlistService.removeMediaFromPlaylist(playlistId, media);
    }

    @DeleteMapping("/{id}")
    public void deletePlaylist(@PathVariable int id) {
        playlistService.deletePlaylist(id);
    }


    @GetMapping("/{id}")
    public Playlist getPlaylistById(@PathVariable int id) {
        return playlistService.getPlaylistById(id);
}


}
