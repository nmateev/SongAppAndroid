package com.wasp.songapp.services;

import com.wasp.songapp.models.Song;
import com.wasp.songapp.repositories.base.Repository;
import com.wasp.songapp.services.base.SongsService;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class HttpSongsService implements SongsService {

    private Repository<Song> songsRepository;


    @Override
    public void addSong(Song newSong) throws Exception {
        songsRepository.add(newSong);
    }

    @Override
    public void deleteSong(int id) throws Exception {
        songsRepository.delete(id);
    }

    @Override
    public void updateSongPlayCounter(int id) throws Exception {
        songsRepository.update(id);
    }

    @Override
    public Song getSongById(int id) throws IOException {
        return songsRepository.getById(id);
    }

    @Override
    public List<Song> getAllSongs() throws IOException {
        return songsRepository.getAll();
    }

    @Override
    public List<Song> getFilteredSongs(String pattern) throws IOException {

        String patternToLower = pattern.toLowerCase();

        return getAllSongs()
                .stream()
                .filter(song -> song
                        .getAuthorName()
                        .toLowerCase()
                        .contains(patternToLower))
                .collect(Collectors.toList());
    }
}
