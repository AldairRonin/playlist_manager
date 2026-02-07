package com.example.playlist_api.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("song")
public class Song extends Media {

    public Song() {}

    

    @Override
    public void play() {}
}
