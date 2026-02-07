package com.example.playlist_api.dto;

import java.util.List;

public class PlaylistDTO {

    private int id;
    private String name;
    private List<MediaDTO> mediaList;

    public PlaylistDTO() {}

    public PlaylistDTO(int id, String name, List<MediaDTO> mediaList) {
        this.id = id;
        this.name = name;
        this.mediaList = mediaList;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<MediaDTO> getMediaList() { return mediaList; }
    public void setMediaList(List<MediaDTO> mediaList) {
        this.mediaList = mediaList;
    }
}
