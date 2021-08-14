package org.codecakes;

public class Song {
    private String title;

    public String getTitle() {
        return title;
    }

    public String getDuration() {
        return duration;
    }

    private String duration;

    Song(String title, String duration) {
        this.title = title;
        this.duration = duration;
    }
}
