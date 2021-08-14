package org.codecakes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
		Album thriller = new Album("Thriller");
		thriller.addSong(new Song("Beat it", "4:18"));
		thriller.addSong(new Song("Billie Jean", "4:54"));

		Album backInBlack = new Album("Back in Black");
		backInBlack.addSong(new Song("Hells Bells", "5:10"));
		backInBlack.addSong(new Song("Back in Black", "4:15"));


		Playlist craigPlaylist = new Playlist();
		craigPlaylist.addAlbum(thriller);
		craigPlaylist.addAlbum(backInBlack);

		craigPlaylist.addSong("Beat it");
		craigPlaylist.addSong("Hells Bells");
		craigPlaylist.addSong("Jingle Bells");
		craigPlaylist.addSong("Billie Jean");
		craigPlaylist.addSong("Back in Black");
		craigPlaylist.printPlaylist();

		Scanner scanner = new Scanner(System.in);
		boolean quit = false;
		boolean goingForward = true;

		LinkedList<Song> playlistSongs = craigPlaylist.getSongLinkedList();
		ListIterator<Song> listIterator = playlistSongs.listIterator();
		System.out.println("------------------------");
		System.out.println("Initializer music player");
		System.out.println("------------------------");
		if (playlistSongs.isEmpty())  {
			System.out.println("Playlist is empty");
			return;
		} else {
			System.out.println("Now playing " + listIterator.next().getTitle());
			printMenu();
		}

		while(!quit) {
			int menuSelection = scanner.nextInt();
			scanner.nextLine();
			switch(menuSelection) {
				case 0:
					System.out.println("stopping playlist");
					quit = true;
					break;
				case 1:
					if (!goingForward) {
						if (listIterator.hasNext()) {
							listIterator.next();
							goingForward = true;
						}
					}
					System.out.println("index: " + listIterator.nextIndex());
					System.out.println("there are " + playlistSongs.size() + " songs in the playlist");
					if (listIterator.hasNext()) {
						Song currentSong = listIterator.next();
						System.out.println("Now playing " + currentSong.getTitle() +
								" for " + currentSong.getDuration());
//						System.out.println("now playing " + listIterator.next().getTitle() +
//								" for " + listIterator.next().getDuration());
					} else {
						System.out.println("last item of playlist");
					}
					break;
				case 2:
					if (goingForward) {
						if (listIterator.hasPrevious()) {
							listIterator.previous();
							goingForward = false;
						}

					}
					if (listIterator.hasPrevious()) {
						System.out.println("now playing " + listIterator.previous().getTitle());
					} else {
						System.out.println("this is the first item on the playlist");
					}
					break;
				case 3:
					printMenu();
					break;

			}

		}

	}
	private static void printMenu() {
		System.out.println("Available commands");
		System.out.println("0: quit");
		System.out.println("1: next song");
		System.out.println("2: previous song");
		System.out.println("3: menu");
	}

}
