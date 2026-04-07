package com.example.musicplaylistmanager;

import java.util.ArrayList;

public class Playlist {
    public String name;
    public ArrayList<String> songs;

    public Playlist(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
    }
}