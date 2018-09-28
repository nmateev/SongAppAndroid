package com.wasp.songappspring.controllers;

import com.wasp.songappspring.models.Song;
import com.wasp.songappspring.services.SongsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/songs")
public class SongsApiController{

    private SongsService songsService;

    @Autowired
    public SongsApiController(SongsService songsService) {
        setSongsService(songsService);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addSong(@RequestBody @Valid Song newSong) {
        songsService.addSong(newSong);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteSong(@PathVariable(value = "id") @Valid int id) {
        songsService.deleteSong(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Song updateSongPlayCounter(@RequestBody @Valid Song songToUpdate, @PathVariable(value = "id") @Valid int id) {
        return songsService.updateSongPlayCounter(songToUpdate,id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Song getSongById(@PathVariable(value = "id") @Valid int id) {
        return songsService.getSongById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Song> getSongs() {
        return songsService.getSongs();
    }

    private void setSongsService(SongsService songsService) {
        this.songsService = songsService;
    }
}
