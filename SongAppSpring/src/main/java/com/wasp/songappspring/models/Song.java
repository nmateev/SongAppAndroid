package com.wasp.songappspring.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "songs")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "song_id")
    private int songId;

    @NotNull
    @Size(min = 2, max = 60)
    @Column(name = "song_title")
    private String songTitle;

    @NotNull
    @Size(min = 2, max = 60)
    @Column(name = "song_author")
    private String authorName;

    @NotNull
    @Size(min = 2, max = 15)
    @Column(name = "song_duration")
    private String songDuration;

    @NotNull
    @Min(value = 0)
    @Column(name = "song_play_count")
    private int playsCount;

    @NotNull
    @Size(min = 5, max = 250)
    @Column(name = "image_url")
    private String imageUrl;

    public Song() {

    }

    public Song(String songTitle, String authorName, String songDuration, int playsCount, String imageUrl) {
        setSongTitle(songTitle);
        setAuthorName(authorName);
        setSongDuration(songDuration);
        setPlaysCount(playsCount);
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

    private void setSongId(int id) {
        this.songId = id;
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

}
