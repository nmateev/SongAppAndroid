package com.wasp.songappspring.controllers;

import com.wasp.songappspring.controllers.base.SongsControllerBase;
import com.wasp.songappspring.services.SongsServiceBase;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class SongsControllerImpl implements SongsControllerBase {

    private SongsServiceBase songsService;

    @RequestMapping(value = "/songs/new", method = RequestMethod.POST)
    @Override
    public void addSong(@RequestBody Song newSong) {
        songsService.addSong(newSong);
    }

    @RequestMapping(value = "/songs/delete/{id}", method = RequestMethod.DELETE)
    @Override
    public void deleteSong(@PathVariable("id") int id) {
        songsService.deleteSong(id);
    }

    @RequestMapping(value = "/songs/update/{id}", method = RequestMethod.PUT)
    @Override
    public void updateSongPlayCounter(@PathVariable("id") int id) {
        songsService.updateSongPlayCounter(id);
    }

    @RequestMapping(value = "/songs/{id}", method = RequestMethod.GET)
    @Override
    public Song getSongById(@PathVariable("id") int id) {
        return songsService.getSongById(id);
    }

    @RequestMapping(value = "/songs", method = RequestMethod.GET)
    @Override
    public List<Song> getSongs() {
        return songsService.getSongs();
    }
}
