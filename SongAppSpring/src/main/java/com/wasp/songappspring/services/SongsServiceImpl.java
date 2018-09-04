package com.wasp.songappspring.services;

import com.wasp.songappspring.models.Song;
import com.wasp.songappspring.repositories.SongsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongsServiceImpl implements SongsServiceBase {
    private SongsRepository songsRepository;

    public SongsServiceImpl(SongsRepository songsRepository) {
        setSongsRepository(songsRepository);
    }

    @Override
    public void addSong(Song newSong) {
        songsRepository.addSong(newSong);
    }

    @Override
    public void deleteSong(int id) {
        songsRepository.deleteSong(id);
    }

    @Override
    public void updateSongPlayCounter(int id) {
        songsRepository.updateSongPlayCounter(id);
    }

    @Override
    public Song getSongById(int id) {
        return songsRepository.getSongById(id);
    }

    @Override
    public List<Song> getSongs() {
        return songsRepository.getSongs();
    }

    private void setSongsRepository(SongsRepository songsRepository) {
        this.songsRepository = songsRepository;
    }
}
