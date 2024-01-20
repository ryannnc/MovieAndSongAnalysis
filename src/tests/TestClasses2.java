package tests;

import org.junit.Test;
import ratings.Movie;
import ratings.Rating;
import ratings.Reviewer;
import ratings.Song;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class TestClasses2 {
    private final double EPSILON = 0.001;

    public void compareDoubles(double d1, double d2) {
        assertTrue(Math.abs(d1 - d2) < EPSILON);
    }

    @Test
    public void testbayesianAverageRating() {
        Song song = new Song("lonely", "justin bieber", "1");
        compareDoubles(song.bayesianAverageRating(0,0),0.0);
        compareDoubles(song.bayesianAverageRating(4,0),0.0);
        compareDoubles(song.bayesianAverageRating(0,5),0.0);
        compareDoubles(song.bayesianAverageRating(2,3),3.0);

        ArrayList<String> cast = new ArrayList<>();
        cast.add("Chris Pratt");
        cast.add("Zoe Saldana");
        cast.add("Dave Bautista");

        Movie movie = new Movie("Guardian of the Galaxy", cast);
        compareDoubles(movie.bayesianAverageRating(0,0),0);
        compareDoubles(movie.bayesianAverageRating(0,0),0.0);
        compareDoubles(movie.bayesianAverageRating(4,0),0.0);
        compareDoubles(movie.bayesianAverageRating(0,5),0.0);
        compareDoubles(movie.bayesianAverageRating(2,3),3.0);

    }
    @Test
    public void testbayesian_bad_on_no_fake_ratings(){
        ArrayList<String> cast = new ArrayList<>();
        cast.add("Chris Pratt");
        cast.add("Zoe Saldana");
        cast.add("Dave Bautista");

        Movie movie = new Movie("Guardian of the Galaxy", cast);
        movie.addRating(new Rating("what",5));
        double merry = movie.bayesianAverageRating(2,5);
        assertEquals(5.0,merry,0.0001);

    }
    @Test
    public void testbayesiansong(){
        Song song = new Song("lonely", "justin bieber", "1");
        compareDoubles(song.bayesianAverageRating(0,0),0.0);
        compareDoubles(song.bayesianAverageRating(4,0),0.0);
        compareDoubles(song.bayesianAverageRating(0,5),0.0);
        song.addRating(new Rating("oh",4));
        compareDoubles(song.bayesianAverageRating(2,4),4.0);
    }


    @Test
    public void testGetMovie() {
        ArrayList<String> cast = new ArrayList<>();
        cast.add("Chris Pratt");
        cast.add("Zoe Saldana");
        cast.add("Dave Bautista");

        Movie movie = new Movie("Guardian of the Galaxy", cast);
        assertEquals("Guardian of the Galaxy", movie.getTitle());
    }

    @Test
    public void testGetMovieCast() {
        ArrayList<String> cast = new ArrayList<>(Arrays.asList("Chris Pratt","Zoe Saldana","Dave Bautista"));
        Movie movie = new Movie("Guardian of the Galaxy", cast);

        ArrayList<String> cast2 = new ArrayList<>(Arrays.asList("Chris Pratt","Zoe Saldana","Dave Bautista"));
        for (int i = 0; i < movie.getCast().size(); i++) {

            assertTrue(movie.getCast().get(i).equalsIgnoreCase(cast2.get(i)));
            assertTrue(movie.getCast().get(i).equalsIgnoreCase(cast.get(i)));
        }
        assertEquals(3,movie.getCast().size());

        System.out.println(movie.getCast());
        System.out.println(cast2);

        ArrayList<String> nuke = new ArrayList<>();
        nuke.add("Robert");
        nuke.add("Chris");
        Movie avengers = new Movie("Avengers", nuke);

        for (int i = 0; i < avengers.getCast().size(); i++) {
            assertTrue(avengers.getCast().get(i).equalsIgnoreCase(nuke.get(i)));
        }

        ArrayList<String> unity = new ArrayList<>();
        unity.add("amy");
        unity.add("james");
        unity.add("daniel");
        unity.add("sammi");
        unity.add("alvin");
        unity.add("leslie");
        Movie life = new Movie("life",unity);
        for (int i = 0; i < life.getCast().size(); i ++){
            assertTrue(life.getCast().get(i).equalsIgnoreCase((unity.get(i))));
        }




    }
    @Test
    public void missing(){
        ArrayList<String> cast = new ArrayList<>();
        cast.add("Chris Pratt");
        cast.add("Zoe Saldana");
        Movie movie = new Movie("Guardian of the Galaxy", cast);

        ArrayList<String> cast2 = new ArrayList<>(cast);
        cast2.add("Dave Bautista");
        Movie movie2 = new Movie("Guardian of the Galaxy", cast2);
        for (int i = 0; i < movie.getCast().size(); i++) {
            assertTrue(movie2.getCast().get(i).equalsIgnoreCase(cast2.get(i)));
        }
    }
}
