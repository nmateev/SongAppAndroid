package com.wasp.songappspring.models;

public class Song {
    //fields
    public int id;
    public String songTitle;
    public String authorName;
    public String songDuration;
    public int playsCount;


    //constructor
    public Song(int id, String songTitle, String authorName, String songDuration, int playsCount) {
        this.id = id;
        this.songTitle = songTitle;
        this.authorName = authorName;
        this.songDuration = songDuration;
        this.playsCount = playsCount;
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
