package com.example.playlist_api.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("podcast")
public class Podcast extends Media {

    public Podcast() {}

   

    @Override
    public void play() {}
}
