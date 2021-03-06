package com.wasp.songapp.models;

import android.support.annotation.NonNull;

import java.io.Serializable;

public class Song implements Serializable, Comparable<Song> {

    private static final int INITIAL_PLAYS_COUNT = 0;

    private int songId;
    private String songTitle;
    private String authorName;
    private String songDuration;
    private int playsCount;
    private String imageUrl;

    public Song() {

    }

    public Song(String songTitle, String authorName, String songDuration, String imageUrl) {
        setSongTitle(songTitle);
        setAuthorName(authorName);
        setSongDuration(songDuration);
        setPlaysCount(INITIAL_PLAYS_COUNT);
        setImageUrl(imageUrl);
    }

    public int getSongId() {
        return songId;
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

    public void setPlaysCount(int playsCount) {
        this.playsCount = playsCount;
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


    private void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    private void setSongId(int song_id) {
        this.songId = song_id;
    }

    @Override
    public int compareTo(@NonNull Song otherSong) {

        int comparison =
                Integer.compare(otherSong.getPlaysCount(),
                        this.getPlaysCount());
        if (comparison != 0) {
            return comparison;
        }
        return this.getAuthorName()
                .compareTo(otherSong.getAuthorName());
    }
}

