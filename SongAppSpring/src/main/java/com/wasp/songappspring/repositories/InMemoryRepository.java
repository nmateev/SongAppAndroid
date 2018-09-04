package com.wasp.songappspring.repositories;

import com.wasp.songappspring.models.Song;
import com.wasp.songappspring.utils.IdGenerator;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryRepository implements SongsRepository {
    //fields
    private static final int INCREMENT_WITH_ONE_PLAY_COUNTS = 1;
    private IdGenerator idGenerator;
    List<Song> songsList;


    //constructor
    public InMemoryRepository(){
        idGenerator=new IdGenerator();
        songsList= new ArrayList<>();
        songsList.add(new Song(idGenerator.getNextId(),"Detelini","Lili Ivanova","3.30",0));
        songsList.add(new Song(idGenerator.getNextId(),"Edin nerazdelen klas","Tonika","3.54",0));
    }


    @Override
    public void addSong(Song newSong) {
        newSong.setId(idGenerator.getNextId());
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
