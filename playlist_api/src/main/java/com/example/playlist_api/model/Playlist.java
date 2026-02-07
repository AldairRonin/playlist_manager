package com.example.playlist_api.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Playlist implements Validatable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany
    @JoinTable(
        name = "playlist_media",
        joinColumns = @JoinColumn(name = "playlist_id"),
        inverseJoinColumns = @JoinColumn(name = "media_id")
    )
    private List<Media> mediaList = new ArrayList<>();

    public Playlist() {}

    public int getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public void setMediaList(List<Media> mediaList) {
    this.mediaList = mediaList;
    }


    public List<Media> getMediaList() { return mediaList; }

    @Override
    public void validate() {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Playlist name cannot be empty");
        }
    }
}
