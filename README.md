# Music Playlist Manager App

## Project Overview

The Music Playlist Manager App is an Android application developed using Android Studio and Java. The application allows users to create and manage playlists by adding, removing, and sorting songs. It demonstrates the use of Android components, list management, and local data storage.

---

## Team Members

* Brinda B
* Kavyashree
* Yashaswini

---

## Objectives

* To develop an Android application using Java
* To implement playlist and song management
* To use ListView for displaying data
* To implement local storage using SharedPreferences

---

## Features

* Create playlists
* Add songs to playlists
* Remove songs using long press
* Sort songs alphabetically
* Persistent storage of data

---

## Technologies Used

* Android Studio
* Java
* XML
* SharedPreferences
* Gson Library

---

## Application Structure

### MainActivity

Displays the list of playlists and provides an option to create a new playlist.

### CreatePlaylistActivity

Allows the user to enter and save a playlist name.

### PlaylistDetailActivity

Allows users to add, remove, and sort songs within a playlist.

---

## Project Structure

MusicPlaylistManager
│
├── app
│   ├── src/main/java/com/example/musicplaylistmanager
│   │   ├── MainActivity.java
│   │   ├── CreatePlaylistActivity.java
│   │   ├── PlaylistDetailActivity.java
│   │   └── Playlist.java
│   │
│   ├── res/layout
│   │   ├── activity_main.xml
│   │   ├── activity_create_playlist.xml
│   │   └── activity_playlist_detail.xml
│   │
│   └── AndroidManifest.xml

---

## How to Run the Application

### Using Emulator

1. Open the project in Android Studio
2. Create or select a virtual device
3. Run the application

### Using Android Device

1. Enable Developer Options
2. Enable USB Debugging
3. Connect the device
4. Run the application

---

## Expected Outcome

The application allows users to manage playlists and songs efficiently. Data is stored locally and remains available even after restarting the application.

---

## Conclusion

This project demonstrates the implementation of an Android application using Java, focusing on list management and local storage. It provides a simple and effective solution for managing playlists.

---

## Additional Resources

Code output screenshots have been attached as a PDF document for reference.
