package com.wasp.songapp.models;

public class Song {

    private static final int INITIAL_PLAYS_COUNT = 0;

    public int id;
    public String songTitle;
    public String authorName;
    public String songDuration;
    public int playsCount;
    public String imageUrl;

    public Song() {

    }

    public Song(String songTitle, String authorName, String songDuration, String imageUrl) {
        setSongTitle(songTitle);
        setAuthorName(authorName);
        setSongDuration(songDuration);
        setPlaysCount(INITIAL_PLAYS_COUNT);
        setImageUrl(imageUrl);
    }


    public String getSongTitle() {
        return songTitle;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getSongDuration() {
        return songDuration;
    }

    public int getPlaysCount() {
        return playsCount;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    private void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    private void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    private void setSongDuration(String songDuration) {
        this.songDuration = songDuration;
    }

    private void setPlaysCount(int playsCount) {
        this.playsCount = playsCount;
    }

    private void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
