package com.example.musicplaylistmanager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button btnAdd;
    ArrayList<Playlist> playlists;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listViewPlaylists);
        btnAdd = findViewById(R.id.btnAddPlaylist);

        playlists = loadData();
        updateList();

        btnAdd.setOnClickListener(v ->
                startActivity(new Intent(this, CreatePlaylistActivity.class))
        );

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(MainActivity.this, PlaylistDetailActivity.class);
            intent.putExtra("index", position);
            startActivity(intent);
        });
    }

    private void updateList() {
        ArrayList<String> names = new ArrayList<>();
        for (Playlist p : playlists) names.add(p.name);

        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, names);

        listView.setAdapter(adapter);
    }

    private ArrayList<Playlist> loadData() {
        SharedPreferences prefs = getSharedPreferences("music", MODE_PRIVATE);
        String json = prefs.getString("data", null);

        if (json == null) return new ArrayList<>();

        Type type = new TypeToken<ArrayList<Playlist>>() {}.getType();
        return new Gson().fromJson(json, type);
    }

    @Override
    protected void onResume() {
        super.onResume();
        playlists = loadData();
        updateList();
    }
}