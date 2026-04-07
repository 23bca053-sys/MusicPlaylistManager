package com.example.musicplaylistmanager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class CreatePlaylistActivity extends AppCompatActivity {

    EditText etName;
    Button btnSave;
    ArrayList<Playlist> playlists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_playlist);

        etName = findViewById(R.id.etPlaylistName);
        btnSave = findViewById(R.id.btnSave);

        playlists = loadData();

        btnSave.setOnClickListener(v -> {
            String name = etName.getText().toString();

            if (name.isEmpty()) {
                Toast.makeText(this, "Enter name", Toast.LENGTH_SHORT).show();
                return;
            }

            playlists.add(new Playlist(name));
            saveData();

            Toast.makeText(this, "Playlist Created", Toast.LENGTH_SHORT).show();
            finish(); // keep this for smooth UX
        });
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