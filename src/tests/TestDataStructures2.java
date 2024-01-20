package tests;

import org.junit.Test;
import ratings.Playlist;
import ratings.Song;
import ratings.datastructures.BinaryTreeNode;
import ratings.datastructures.LinkedListNode;
import ratings.datastructures.SongBayesianRatingComparator;
import ratings.datastructures.SongTitleComparator;

import static org.junit.Assert.*;

public class TestDataStructures2 {

    public void compare(Song actual, Song expected){
        assertTrue(actual.getArtist().equalsIgnoreCase(expected.getArtist()));
        assertTrue(actual.getTitle().equalsIgnoreCase(expected.getTitle()));
        assertTrue(actual.getSongID().equalsIgnoreCase(expected.getSongID()));
    }

    public void compareLinkedListsOfStringsIgnoreCase(LinkedListNode<Song> actual, LinkedListNode<Song> expected){
        if(expected == null){
            assertNull(actual);
        }else{
            assertNotNull(actual);
            compare(actual.getValue(),expected.getValue());
            compareLinkedListsOfStringsIgnoreCase(actual.getNext(), expected.getNext());
        }
    }

    public void addallsongs(Playlist playlist, LinkedListNode<Song> song) {
        if (song != null) {
            playlist.addSong(song.getValue());
            addallsongs(playlist, song.getNext());
        }
    }

    @Test
    public void playlistthreesongs(){

        Playlist playlist = new Playlist(new SongTitleComparator());

        LinkedListNode<Song> song = new LinkedListNode<>((new Song("Apollo", "Ryan", "A" )), null);
        song.append(new Song("Backdoor", "Becky", "B"));
        song.append(new Song("Dynamite","BTS","D"));
        song.append(new Song("Fourth","Daisy","F"));

        addallsongs(playlist, song);

        LinkedListNode<Song> song2 = new LinkedListNode<>((new Song("Apollo", "Ryan", "A" )), null);
        song2.append(new Song("Backdoor", "Becky", "B"));
        song2.append(new Song("Dynamite","BTS","D"));
        song2.append(new Song("Fourth","Daisy","F"));


        compareLinkedListsOfStringsIgnoreCase(playlist.getSongList(), song2);


    }

    @Test
    public void three(){
        Playlist playlist = new Playlist(new SongTitleComparator());

        LinkedListNode<Song> song = new LinkedListNode<>((new Song("Lonely","Justin","L")),null);
        song.append(new Song("Depression","Drake","D"));
        addallsongs(playlist, song);
        assertEquals(2,playlist.getSongList().size());

    }



    @Test
    public void testaddSong(){

        Playlist playlist = new Playlist(new SongTitleComparator());
        playlist.addSong(new Song("Lonely","Justin","L"));
        playlist.addSong(new Song("Depression","Drake","D"));
        playlist.addSong(new Song("Happy","Drake","H"));

        LinkedListNode<Song> song = playlist.getSongList();
        assertEquals("Depression",song.getValue().getTitle());
        compareLinkedListsOfStringsIgnoreCase(playlist.getSongList(),song);


    }
}
