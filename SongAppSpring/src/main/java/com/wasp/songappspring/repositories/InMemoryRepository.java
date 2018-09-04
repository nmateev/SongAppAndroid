package com.wasp.songappspring.repositories;

import com.wasp.songappspring.models.Song;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryRepository implements SongsRepository {
    //fields
    private static final int INCREMENT_WITH_ONE_PLAY_COUNTS = 1;
    List<Song> songsList= new ArrayList<>();


    //constructor
    public InMemoryRepository(){
        songsList.add(new Song(1,"Detelini","Lili Ivanova","3,30",0));
        songsList.add(new Song(2,"Edin nerazdelen klas","Tonika","3,54",0));
    }


    @Override
    public void addSong(Song newSong) {
        songsList.add(newSong);
    }

    @Override
    public void deleteSong(int id) {
        Song songToRemove=getSongById(id);
        songsList.remove(songToRemove);
    }

    @Override
    public void updateSongPlayCounter(int id) {
        Song songToUpdate=getSongById(id);
        songToUpdate.setPlaysCount(songToUpdate.getPlaysCount()+INCREMENT_WITH_ONE_PLAY_COUNTS);
    }

    @Override
    public Song getSongById(int id) {
       return songsList.stream()
                .filter(song -> song.id==id)
                .findFirst()
                .orElse(null);

    }

    @Override
    public List<Song> getSongs() {
        return songsList;
    }
}
