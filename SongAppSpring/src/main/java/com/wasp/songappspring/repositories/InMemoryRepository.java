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
        songsList.add(new Song(idGenerator.getNextId(),"Eastside","Benny Blanco, Hasley & Khalid","2.53",0,
                "https://www.google.bg/search?q=benny+blanco+halsey+%26+khalid+%E2%80%93+eastside&source=lnms&tbm=isch&sa=X&ved=0ahUKEwiwqMXJpaLdAhVJliwKHTcjDXYQ_AUICigB&biw=1536&bih=759#imgrc=lZVfA03w1hxQeM:"));
        songsList.add(new Song(idGenerator.getNextId(),"Promises","Calvin Harris, Sam Smith","4.05",0,
                "https://www.google.bg/search?biw=1536&bih=759&tbm=isch&sa=1&ei=XfmOW7atJIGqsQHiibLADw&q=calvin+harris&oq=calvin+harris&gs_l=img.3..0l2j0i30k1l8.5821.6674.0.7130.10.5.0.0.0.0.135.524.3j2.5.0....0...1c.1.64.img..8.2.250...0i19k1j0i8i30i19k1.0.C13DdlQjr98#imgrc=QSxuu1kmjOL7UM:"));
        songsList.add(new Song(idGenerator.getNextId(),"Shotgun","George Ezra","3.27",0,
                "https://www.google.bg/search?biw=1536&bih=759&tbm=isch&sa=1&ei=ZfmOW8__M4OasgG90bXoBQ&q=george+ezra&oq=george+e&gs_l=img.3.0.0j0i30k1l9.201655.204195.0.205320.8.8.0.0.0.0.112.659.5j2.7.0....0...1c.1.64.img..1.7.655...35i39k1j0i67k1j0i10k1.0.9f08N-fES0I#imgrc=61azANPGoaYrNM:"));
        songsList.add(new Song(idGenerator.getNextId(),"In my feelings","Drake","7.59",0,
                "https://www.google.bg/search?biw=1536&bih=759&tbm=isch&sa=1&ei=nKKOW8riEcL8sQHojIeIAw&q=drake&oq=drake&gs_l=img.3..0l10.8664.9262.0.9522.5.5.0.0.0.0.114.469.4j1.5.0....0...1c.1.64.img..0.5.468...35i39k1j0i67k1j0i10k1.0.7PQvPaBvFUs#imgrc=OVd5gRxKTtUTSM:"));
        songsList.add(new Song(idGenerator.getNextId(),"Girls like you","Maroon 5","4.30",0,
                "https://www.google.bg/search?biw=1536&bih=759&tbm=isch&sa=1&ei=M_qOW4agMMqasAHP95ewCg&q=maroon+5&oq=maroon+5&gs_l=img.3..0l7j0i30k1l3.53963.56683.0.56877.8.7.0.1.1.0.114.643.6j1.7.0....0...1c.1.64.img..0.8.641...35i39k1j0i67k1j0i10k1.0.wW92lN_wtxQ#imgrc=Q8kTnZjq7-AmXM:"));
        songsList.add(new Song(idGenerator.getNextId(),"No brainer","Justin Bieber,Chance the rapper & Quavo","4.22",0,
                "https://www.google.bg/search?biw=1536&bih=759&tbm=isch&sa=1&ei=svqOW8imIoqXsAG89LuYCw&q=justin+bieber&oq=just&gs_l=img.3.1.0i67k1j0j0i67k1j0l6j0i67k1.24287.25084.0.26990.4.3.0.1.1.0.110.286.2j1.3.0....0...1c.1.64.img..0.4.285....0.kEnNg6rU6qA#imgrc=QGnNsYZPNMQ-UM:"));
        songsList.add(new Song(idGenerator.getNextId(),"God is a woman","Ariana Grande","4.01",0,
                "https://www.google.bg/search?biw=1536&bih=759&tbm=isch&sa=1&ei=zvqOW9OsE6GQmgWktKm4CA&q=ariana+grande&oq=ar&gs_l=img.3.0.0i67k1l4j0j0i67k1j0l2j0i67k1j0.46061.46420.0.47982.2.2.0.0.0.0.111.199.1j1.2.0....0...1c.1.64.img..0.2.198...35i39k1.0.seZF5qsX1Uk#imgrc=qiRz7gHUi21ScM:"));
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
