package tests;

import org.junit.Test;
import ratings.FileReader;
import ratings.Movie;
import ratings.Rating;
import ratings.Song;
import ratings.datastructures.LinkedListNode;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static ratings.FileReader.readMovies;
import static ratings.FileReader.readSongs;

public class TestFiles {

    private void compare(Song expected, Song actual){
        assertEquals(expected.getTitle(), actual.getTitle());
        assertEquals(expected.getArtist(), actual.getArtist());
        assertEquals(expected.getSongID(), actual.getSongID());
        assertEquals(expected.getRatings().size(),actual.getRatings().size());
    }
    public void compareRating(LinkedListNode<Rating> l1, LinkedListNode<Rating> l2) {
        if(!(l1 == null && l2 == null)){
            assertTrue("l1 was null, but l2 was not", l1 != null);
            assertTrue("l2 was null, but l1 was not", l2 != null);
            assertEquals(l1.size(),l2.size());
            assertEquals(l1.getValue().getReviewerID(),l2.getValue().getReviewerID());
            assertEquals(l1.getValue().getRating(),l2.getValue().getRating());
            compareRating(l1.getNext(), l2.getNext());
        }
    }
    private void compareMovies(Movie expected, Movie actual){
        assertEquals(expected.getTitle(),actual.getTitle());
        assertEquals(expected.getCast(),actual.getCast());
    }

    public void compareArrayLists(ArrayList<Song> expected, ArrayList<Song> actual){
        assertEquals(expected.size(),actual.size());
        for (Song expectedsong : expected){
            boolean list = false;
            for (Song actualsong : actual){
                if (expectedsong.getTitle().equals(actualsong.getTitle()) &&
                expectedsong.getArtist().equals(actualsong.getArtist()) &&
                expectedsong.getSongID().equals(actualsong.getSongID())) {
                    compare(expectedsong,actualsong);
                    compareRating(expectedsong.getRatings(),actualsong.getRatings());
                    list = true ;
                    break;
                }
            }
            assertTrue(list);
        }
    }

    public void compareMovieLists(ArrayList<Movie> expected, ArrayList<Movie> actual){
        assertEquals(expected.size(),actual.size());
        for (Movie expectedmovie: expected){
            boolean list = false;
            for (Movie actualmovie : actual){
                if (expectedmovie.getTitle().equals(actualmovie.getTitle()) &&
                        expectedmovie.getCast().equals(actualmovie.getCast())){
                    compareMovies(expectedmovie,actualmovie);
                    list = true ;
                    break;
                }
            }
            assertTrue(list);
        }
    }


    @Test
    public void testReadOneSongs() {
        String filename = "data/ratings_test.csv";
        ArrayList<Song> actual = readSongs(filename);
        ArrayList<Song> expected = new ArrayList<>();

        Song song = new Song("Blinding Lights", "The Weeknd", "0VjIjW4GlUZAMYd2vXMi3b");
        song.addRating(new Rating("18", 5));
        song.addRating(new Rating("215",3));

        expected.add(song);

        compareArrayLists(expected,actual);
        }
    @Test
    public void testReadmorethanonesong(){
        String filename = "data/ratings_test2.csv";
        ArrayList<Song> actual = readSongs(filename);
        ArrayList<Song> expected = new ArrayList<>();

        Song song = new Song("Blinding Lights", "The Weeknd", "0VjIjW4GlUZAMYd2vXMi3b");
        song.addRating(new Rating("18", 5));

        Song song2 = new Song("Chandelier","Sia","2s1sdSqGcKxpPr5lCl7jAV");
        song2.addRating(new Rating("59",4));

        Song song3 = new Song("MONACO","Bad Bunny","4MjDJD8cW7iVeWInc2Bdyj");
        song3.addRating(new Rating("167",4));
        song3.addRating(new Rating("187",4));


        expected.add(song);
        expected.add(song2);
        expected.add(song3);

        compareArrayLists(expected,actual);

    }

    @Test
    public void testNofile(){
        String filename = "date/nofile.csv";
        ArrayList<Song> actual = readSongs(filename);
        ArrayList<Song> expected = new ArrayList<>();

        compareArrayLists(expected,actual);
    }

    @Test
    public void testReadmovie(){
        String filename = "data/movies_test.csv";
        ArrayList<Movie> actual = readMovies(filename);
        ArrayList<Movie> expected = new ArrayList<>();

        ArrayList<String> cast = new ArrayList<>(Arrays.asList("Mary Steenburgen","Sean Patrick Flanery","Lance Henriksen","Jeff Goldblum","Brandon Smith"));
        Movie movie = new Movie("Powder",cast);
        expected.add(movie);

        compareMovieLists(expected,actual);

    }

    @Test
    public void testReadmorethanonemovie(){
        String filename = "data/movies_test2.csv";
        ArrayList<Movie> actual = readMovies(filename);
        ArrayList<Movie> expected = new ArrayList<>();

        ArrayList<String> cast = new ArrayList<>(Arrays.asList("Mary Steenburgen","Sean Patrick Flanery","Lance Henriksen","Jeff Goldblum","Brandon Smith"));
        Movie movie = new Movie("Powder",cast);
        expected.add(movie);

        
        ArrayList<String> cast2 = new ArrayList<>(Arrays.asList("Kirstie Alley","Steve Guttenberg","Ashley Olsen","Mary-Kate Olsen","Philip Bosco"));
        Movie movie2 = new Movie("It Takes Two",cast2);
        expected.add(movie2);



        ArrayList<String> cast3 = new ArrayList<>(Arrays.asList("Sylvester Stallone","Antonio Banderas","Julianne Moore","Muse Watson","Steve Kahan","Kelly Rowan","Reed Diamond"));
        Movie movie3 = new Movie("Assassins",cast3);
        expected.add(movie3);

        compareMovieLists(expected,actual);
    }

    @Test
    public void testnomovie(){
        String filename = "data/doesnotexist.csv";
        ArrayList<Movie> actual = readMovies(filename);
        ArrayList<Movie> expected = new ArrayList<>();

        compareMovieLists(expected,actual);
    }
}
