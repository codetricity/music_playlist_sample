package org.codecakes;

import java.util.ArrayList;
import java.util.LinkedList;

public class Playlist {
    private ArrayList<Album> albumArrayList = new ArrayList<>();

    public LinkedList<Song> getSongLinkedList() {
        return songLinkedList;
    }

    private LinkedList<Song> songLinkedList = new LinkedList<>();

    public  void addAlbum(Album album) {
        albumArrayList.add(album);
    }

    public void addSong(String songName) {
        for (int i = 0; i < albumArrayList.size(); i++) {
            int songIndex = albumArrayList.get(i).getSongIndexByName(songName);
//            System.out.println("from addSong in Playlist, index is " + songIndex);
            // do not need this check and can eliminate the if statement.
            // just make sure the index is not -1
            if (songIndex == -1) {

//                System.out.println(songName + " is not in album " + albumArrayList.get(i).getName());
            } else {
                songLinkedList.add(albumArrayList.get(i).getSongByIndex(songIndex));
                System.out.println("added " + songName + " to playlist");
                break;
            }
        }

    }

    public void printPlaylist() {
        System.out.println("Your playlist of songs");
        System.out.println("----------------------");
        for (int i = 0; i < songLinkedList.size(); i++) {
            System.out.println(songLinkedList.get(i).getTitle());
        }
    }

}
