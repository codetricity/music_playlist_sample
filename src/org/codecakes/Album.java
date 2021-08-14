package org.codecakes;

import java.util.ArrayList;

public class Album {

    public String getName() {
        return name;
    }

    private String name;
    private ArrayList<Song> songArrayList = new ArrayList<>();

    Album(String name) {
        this.name = name;
    }

    public ArrayList<Song> getSongArrayList() {
        return songArrayList;
    }

    public void addSong(Song song) {
        songArrayList.add(song);
    }

    public Song getSongByIndex(int index) {
        return songArrayList.get(index);
    }

    int getSongIndexByName(String songName) {
        int songIndex = -1;
        for (int i = 0; i < songArrayList.size(); i++){
            String title = songArrayList.get(i).getTitle();
            if (title.equals(songName)) {
//                System.out.println("found song at index " + i);
                songIndex = i;
                break;
            }
        }
//        System.out.println("returning from getSongIndexByName index = " + songIndex);
        return songIndex;
    }

}
