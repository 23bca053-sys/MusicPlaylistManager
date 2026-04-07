package com.example.musicplaylistmanager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.*;

public class PlaylistDetailActivity extends AppCompatActivity {

    EditText etSong;
    Button btnAdd, btnSort;
    ListView listView;

    ArrayList<Playlist> playlists;
    Playlist currentPlaylist;
    int index;

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist_detail);

        etSong = findViewById(R.id.etSong);
        btnAdd = findViewById(R.id.btnAddSong);
        btnSort = findViewById(R.id.btnSort);
        listView = findViewById(R.id.listSongs);

        playlists = loadData();

        index = getIntent().getIntExtra("index", -1);

        if (index == -1 || index >= playlists.size()) {
            Toast.makeText(this, "Error loading playlist", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        currentPlaylist = playlists.get(index);
        updateList();

        btnAdd.setOnClickListener(v -> {
            String song = etSong.getText().toString();
            if (song.isEmpty()) return;

            currentPlaylist.songs.add(song);
            saveData();
            updateList();
        });

        btnSort.setOnClickListener(v -> {
            Collections.sort(currentPlaylist.songs);
            saveData();
            updateList();
        });

        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            currentPlaylist.songs.remove(position);
            saveData();
            updateList();
            return true;
        });
    }

    private void updateList() {
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                currentPlaylist.songs);
        listView.setAdapter(adapter);
    }

    private void saveData() {
        SharedPreferences prefs = getSharedPreferences("music", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("data", new Gson().toJson(playlists));
        editor.apply();
    }

    private ArrayList<Playlist> loadData() {
        SharedPreferences prefs = getSharedPreferences("music", MODE_PRIVATE);
        String json = prefs.getString("data", null);

        if (json == null) return new ArrayList<>();

        Type type = new TypeToken<ArrayList<Playlist>>() {}.getType();
        return new Gson().fromJson(json, type);
    }
}