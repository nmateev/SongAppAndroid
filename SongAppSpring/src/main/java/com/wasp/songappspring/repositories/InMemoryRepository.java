package com.wasp.songappspring.repositories;

import com.wasp.songappspring.models.Song;
import com.wasp.songappspring.utils.IdGenerator;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class InMemoryRepository implements SongsRepository {
    //fields
    private static final int INCREMENT_WITH_ONE_PLAY_COUNTS = 1;
    private IdGenerator idGenerator;
    List<Song> songsList;


    //constructor
    public InMemoryRepository() {
        idGenerator = new IdGenerator();
        songsList = new ArrayList<>();
        songsList.add(new Song(idGenerator.getNextId(), "Eastside", "Benny Blanco, Hasley & Khalid", "2.53", 0,
                "https://i1.wp.com/www.themiddlephinger.com/wp-content/uploads/2018/07/kurtbiersmith_35575312_264523974128408_8451742666336501760_n.jpg?zoom=1.25&resize=791%2C452"));
        songsList.add(new Song(idGenerator.getNextId(), "Promises", "Calvin Harris, Sam Smith", "4.05", 0,
                "https://dancingastro-wpengine.netdna-ssl.com/wp-content/uploads/2017/05/calvin-harris-2017-42-west.jpg"));
        songsList.add(new Song(idGenerator.getNextId(), "Shotgun", "George Ezra", "3.27", 0,
                "https://images-na.ssl-images-amazon.com/images/I/717F7NA799L.jpg"));
        songsList.add(new Song(idGenerator.getNextId(), "In my feelings", "Drake", "7.59", 0,
                "https://thefader-res.cloudinary.com/private_images/w_1260,c_limit,f_auto,q_auto:best/drake-views-from-the-6-cover-story-interview_ic4ox9/drake.jpg"));
        songsList.add(new Song(idGenerator.getNextId(), "Girls like you", "Maroon 5", "4.30", 0,
                "https://www.thoughtco.com/thmb/Y6w7-iTVODuN2JCtG3y97qP5lIw=/768x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/maroon-5-5b103f953128340036787a58.jpg"));
        songsList.add(new Song(idGenerator.getNextId(), "No brainer", "Justin Bieber,Chance the rapper & Quavo", "4.22", 0,
                "https://pbs.twimg.com/profile_images/898295311893880832/bCps4HFV_400x400.jpg"));
        songsList.add(new Song(idGenerator.getNextId(), "God is a woman", "Ariana Grande", "4.01", 0,
                "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/ariana-grande-impressions-1525271618.jpg?resize=980:*"));
        songsList.add(new Song(idGenerator.getNextId(), "All i am", "Jess Glynne", "3.58", 0,
                "http://www.officialcharts.com/media/648195/jess-glynne-1100.jpg?width=796&mode=stretch"));
        songsList.add(new Song(idGenerator.getNextId(), "Ring ring", "Jax Jones, Mabel ft.Rich The Kid", "4.00", 0,
                "https://dubiks.com/wp-content/uploads/2018/07/Jax-Jones-Mabel-Ring-Ring-ft.-Rich-The-Kid-e1530704631260.jpg"));
        songsList.add(new Song(idGenerator.getNextId(), "In my mind", "Dynoro & Gigi D'agostino", "3.06", 0,
                "https://www.djmagitalia.com/wp-content/uploads/2018/06/Gigi_DAgostino_2-e1445012021424-1024x577.jpg"));
        songsList.add(new Song(idGenerator.getNextId(), "Nevermind", "Dennis Lloyd", "2.37", 0,
                "https://s3.amazonaws.com/files.madeinkatana.com/warners/uploads/5acd92a231b79.jpg"));
        songsList.add(new Song(idGenerator.getNextId(), "Youngblood", "5 seconds of summer", "3.49", 0,
                "https://www.much.com/wp-content/uploads/2017/04/Five-Seconds-of-Summer-Return.jpg"));
        songsList.add(new Song(idGenerator.getNextId(), "Rise", "Jonas Blue ft.Jack&Jack", "3.39", 0,
                "https://www.billboard.com/files/styles/article_main_image/public/media/jonas-blue-jack-and-jack-2018-billboard-1548.jpg"));
        songsList.add(new Song(idGenerator.getNextId(), "Don't leave me alone", "David Guetta ft. Anne-Marie", "3.07", 0,
                "https://i1.wp.com/jonalisblog.com/wp-content/uploads/2018/07/david-guetta-anne-marie-dont-leave-me-alone.png?w=868"));
        songsList.add(new Song(idGenerator.getNextId(), "Solo", "Clean Bandit ft.Demi Lovato", "3.44", 0,
                "http://www.njoy.bg/web/files/article_images/2018/06/21582/thumb_835x510_20217.jpg"));
    }


    @Override
    public void addSong(Song newSong) {
        newSong.setId(idGenerator.getNextId());
        songsList.add(newSong);
    }

    @Override
    public void deleteSong(int id) {
        Song songToRemove = getSongById(id);
        songsList.remove(songToRemove);
    }

    @Override
    public Song updateSongPlayCounter(Song songToUpdate, int id) {
        Song foundSong = getSongById(id);
        if (!Objects.equals(foundSong, null)) {
            int indexOfSongToUpdate =
                    songsList
                            .indexOf(foundSong);
            songsList.set(indexOfSongToUpdate, songToUpdate);
            return songsList.get(indexOfSongToUpdate);
        }

        throw new IllegalArgumentException();
    }

    @Override
    public Song getSongById(int id) {
        return songsList.stream()
                .filter(song -> song.id == id)
                .findFirst()
                .orElse(null);

    }

    @Override
    public List<Song> getSongs() {
        return songsList;
    }
}
