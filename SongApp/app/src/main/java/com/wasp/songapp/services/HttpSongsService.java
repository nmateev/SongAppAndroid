package com.wasp.songapp.services;

import com.wasp.songapp.models.Song;
import com.wasp.songapp.repositories.base.Repository;
import com.wasp.songapp.services.base.SongsService;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class HttpSongsService implements SongsService {

    private final Repository<Song> mSongsRepository;

    public HttpSongsService(Repository<Song> songsRepository) {
        mSongsRepository = songsRepository;
    }


    @Override
    public void addSong(Song newSong) throws Exception {
        mSongsRepository.add(newSong);
    }

    @Override
    public void deleteSong(int id) throws Exception {
        mSongsRepository.delete(id);
    }

    @Override
    public void updateSongPlayCounter(int id) throws Exception {
        mSongsRepository.update(id);
    }

    @Override
    public Song getSongById(int id) throws IOException {
        return mSongsRepository.getById(id);
    }

    @Override
    public List<Song> getAllSongs() throws IOException {
        return mSongsRepository.getAll();
    }

    @Override
    public List<Song> getFilteredSongs(String searchPattern) throws IOException {

        String searchPatternLowerCase = searchPattern.toLowerCase();

        return getAllSongs()
                .stream()
                .filter(song -> song
                        .getAuthorName()
                        .toLowerCase()
                        .contains(searchPatternLowerCase))
                .collect(Collectors.toList());
    }

}
