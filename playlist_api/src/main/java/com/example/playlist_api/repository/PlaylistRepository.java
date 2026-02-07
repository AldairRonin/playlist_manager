package com.example.playlist_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.playlist_api.model.Playlist;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {
}
