package com.wasp.songappspring.models;

import com.wasp.songappspring.utils.IdGenerator;

public class Song {
    //fields
    public int id;
    public String songTitle;
    public String authorName;
    public String songDuration;
    public int playsCount;


    //constructor

    public Song(){

    }
    public Song(String songTitle, String authorName, String songDuration, int playsCount) {
        this.songTitle = songTitle;
        this.authorName = authorName;
        this.songDuration = songDuration;
        this.playsCount = playsCount;
    }

    public Song(int id,String songTitle, String authorName, String songDuration, int playsCount){
        this(songTitle,authorName,songDuration,playsCount);
        this.setId(id);
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getSongDuration() {
        return songDuration;
    }

    public void setSongDuration(String songDuration) {
        this.songDuration = songDuration;
    }

    public int getPlaysCount() {
        return playsCount;
    }

    public void setPlaysCount(int playsCount) {
        this.playsCount = playsCount;
    }
}
