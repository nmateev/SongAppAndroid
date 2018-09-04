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
        songsList.add(new Song(idGenerator.getNextId(),"Eastside","Benny Blanco, Hasley & Khalid","2.53",0,""));
        songsList.add(new Song(idGenerator.getNextId(),"Promises","Calvin Harris, Sam Smith","4.05",0,""));
        songsList.add(new Song(idGenerator.getNextId(),"Shotgun","George Ezra","3.27",0,""));
        songsList.add(new Song(idGenerator.getNextId(),"In my feelings","Drake","7.59",0,
                "https://www.google.bg/search?biw=1536&bih=759&tbm=isch&sa=1&ei=nKKOW8riEcL8sQHojIeIAw&q=drake&oq=drake&gs_l=img.3..0l10.8664.9262.0.9522.5.5.0.0.0.0.114.469.4j1.5.0....0...1c.1.64.img..0.5.468...35i39k1j0i67k1j0i10k1.0.7PQvPaBvFUs#imgrc=OVd5gRxKTtUTSM:"));
        songsList.add(new Song(idGenerator.getNextId(),"Girls like you","Maroon 5","4.30",0,""));
        songsList.add(new Song(idGenerator.getNextId(),"No brainer","Justin Bieber,Chance the rapper & Quavo","4.22",0,""));
        songsList.add(new Song(idGenerator.getNextId(),"God is a woman","Ariana Grande","4.01",0,""));
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
