package com.example.playlist_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.playlist_api.model.Media;
import com.example.playlist_api.model.Playlist;
import com.example.playlist_api.repository.PlaylistRepository;

@Service
public class PlaylistService {

    private final PlaylistRepository playlistRepository;

    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    public Playlist createPlaylist(String name) {
        Playlist playlist = new Playlist();
        playlist.setName(name);
        return playlistRepository.save(playlist);
    }

    public List<Media> getPlaylistMedia(int playlistId) {
        Playlist playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new RuntimeException("Playlist not found"));

        return playlist.getMediaList();
    }

    public void addMedia(Playlist playlist, Media media) {
        playlist.getMediaList().add(media);
        playlistRepository.save(playlist);
    }

    public void removeMedia(Playlist playlist, Media media) {
        playlist.getMediaList().remove(media);
        playlistRepository.save(playlist);
    }

    public int getTotalDuration(int playlistId) {
        return getPlaylistMedia(playlistId).stream()
                .mapToInt(Media::getDuration)
                .sum();
    }

    public Media getLongestMedia(int playlistId) {
        return getPlaylistMedia(playlistId).stream()
                .max((m1, m2) -> Integer.compare(m1.getDuration(), m2.getDuration()))
                .orElse(null);
    }

    public void addMediaToPlaylist(int playlistId, Media media) {
    Playlist playlist = playlistRepository.findById(playlistId)
            .orElseThrow(() -> new RuntimeException("Playlist not found"));

    playlist.getMediaList().add(media);
    playlistRepository.save(playlist);
    }

    public void removeMediaFromPlaylist(int playlistId, Media media) {
    Playlist playlist = playlistRepository.findById(playlistId)
            .orElseThrow(() -> new RuntimeException("Playlist not found"));

    playlist.getMediaList().remove(media);
    playlistRepository.save(playlist);
    }

    public void deletePlaylist(int id) {
    playlistRepository.deleteById(id);
    }


    public List<Playlist> getAllPlaylists() {
    return playlistRepository.findAll();
    }

    public Playlist getPlaylistById(int id) {
    return playlistRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Playlist not found"));
    }


}
