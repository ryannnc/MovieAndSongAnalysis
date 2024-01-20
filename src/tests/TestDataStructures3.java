package tests;

import org.junit.Test;
import ratings.DegreesOfSeparation;
import ratings.Movie;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TestDataStructures3 {
    @Test
    public void testDegreeofSeparation(){
        ArrayList<Movie> movie = new ArrayList<>();
        ArrayList<String> cast = new ArrayList<>(Arrays.asList("Chris Pratt","Brad Pitt","Kevin Bacon"));
        Movie movie1 = new Movie("Sleepers",cast);
        movie.add(movie1);
        DegreesOfSeparation degree = new DegreesOfSeparation(movie);

        int computed = degree.degreesOfSeparation("Chris Pratt","Chris Pratt");
        assertEquals(0,computed);

        int computed2 = degree.degreesOfSeparation("Chris Pratt","Brad Pitt");
        assertEquals(1,computed2);

    }
    @Test
    public void testmissing(){
        ArrayList<Movie> movie = new ArrayList<>();
        ArrayList<String> cast = new ArrayList<>(Arrays.asList("Chris Pratt","Brad Pitt","Kevin Bacon"));
        Movie movie1 = new Movie("Sleepers",cast);
        DegreesOfSeparation degree = new DegreesOfSeparation(movie);
        movie.add(movie1);

        int computed = degree.degreesOfSeparation("Barry Allen","Chris Pratt");
        assertEquals(-1,computed);
    }
    @Test
    public void testalways_distance_one(){
        ArrayList<Movie> movie = new ArrayList<>();
        ArrayList<String> cast = new ArrayList<>(Arrays.asList("Chris Pratt","Brad Pitt","Kevin Bacon"));
        Movie movie1 = new Movie("Sleepers",cast);

        ArrayList<String> cast2 = new ArrayList<>(Arrays.asList("Chris Pratt","Zoe Saldana","Will Poulter"));
        Movie movie2 = new Movie("Guardians of the Galaxy Vol. 3",cast2);
        movie.add(movie1);
        movie.add(movie2);

        DegreesOfSeparation degree = new DegreesOfSeparation(movie);
        int computed = degree.degreesOfSeparation("Brad Pitt","Zoe Saldana");
        assertEquals(2,computed);


    }

}
