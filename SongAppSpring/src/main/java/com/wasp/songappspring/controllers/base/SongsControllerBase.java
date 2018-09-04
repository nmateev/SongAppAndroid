package com.wasp.songappspring.controllers.base;

import java.util.List;

public interface SongsControllerBase {

    void addSong(Song newSong);

    void deleteSong(int id);

    void updateSongPlayCounter(int id);

    Song getSongById(int id);

    List<Song> getSongs();

}
