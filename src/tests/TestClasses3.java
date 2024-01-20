package tests;
import org.junit.Test;
import ratings.*;
import ratings.datastructures.LinkedListNode;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static ratings.FileReader.*;

public class TestClasses3 {
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
    public void compareArrayRatable(ArrayList<Ratable> expected, ArrayList<Ratable> actual){
        assertEquals(expected.size(),actual.size());
        for(int i=0; i<expected.size(); i++){
            assertEquals(expected.get(i).getTitle(),actual.get(i).getTitle());
        }
    }
    private void compareMovies(Movie expected, Movie actual){
        assertEquals(expected.getTitle(),actual.getTitle());
        assertEquals(expected.getCast(),actual.getCast());
        compareRating(expected.getRatings(),actual.getRatings());
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
    public void testnomovie(){
        String filename = "data/doesnotexist.csv";
        String filename1 = "data/donotexist.csv" ;
        ArrayList<Movie> actual = FileReader.readMovieRatings(FileReader.readMovies(filename1),filename);
        ArrayList<Movie> expected = new ArrayList<>();

        compareMovieLists(expected,actual);
    }

    @Test
    public void testnorating(){
        String movie = "data/Test_Classes_Movie2.csv";
        String movieRating = "data/Test_Classes_MovieRating2.csv";

        ArrayList<Movie> actual = FileReader.readMovieRatings(FileReader.readMovies(movie),movieRating);
        ArrayList<Movie> expected = new ArrayList<>();

        ArrayList<String> cast3 = new ArrayList<>(Arrays.asList("Sylvester Stallone","Antonio Banderas","Julianne Moore","Muse Watson","Steve Kahan","Kelly Rowan","Reed Diamond"));
        Movie movie3 = new Movie("Assassins",cast3);


        compareMovieLists(expected,actual);


    }

    @Test
    public void testreadmovierating(){
        String movie = "data/Test_Classes_Movie.csv";
        String movieRating = "data/Test_Classes_MovieRating.csv";

        ArrayList<Movie> actual = FileReader.readMovieRatings(FileReader.readMovies(movie),movieRating);
        ArrayList<Movie> expected = new ArrayList<>();


        ArrayList<String> cast = new ArrayList<>(Arrays.asList("Sylvester Stallone",
                "Talia Shire","Burt Young","Carl Weathers","Burgess Meredith",
                "Tony Burton","Mr. T","Hulk Hogan"))
        ;
        Movie movie1 = new Movie("Rocky III",cast);
        movie1.addRating(new Rating("1",2));

        ArrayList<String> cast2 = new ArrayList<>(Arrays.asList("Sylvester Stallone",
                "Talia Shire","Burt Young","Carl Weathers","Burgess Meredith",
                "Tony Burton","Mr. T","Hulk Hogan"
        ));

        ArrayList<String> cast3 = new ArrayList<>(Arrays.asList("Sylvester Stallone",
                "Talia Shire","Burt Young","Carl Weathers","Brigitte Nielsen",
                "Tony Burton","Dolph Lundgren","James Brown"));


        Movie movie3 = new Movie("Rocky IV",cast3);
        movie3.addRating(new Rating("63",4));
        movie3.addRating(new Rating("41",4));
        movie3.addRating(new Rating("22",3));


        Movie movie2 = new Movie("Rocky II",cast2);
        movie2.addRating(new Rating("61",2));


        expected.add(movie1);
        expected.add(movie2);
        expected.add(movie3);

        compareMovieLists(expected,actual);

    }

    @Test
    public void testmedia(){
        String song = "data/Test_Classes_Song1.csv";
        String movies = "data/Test_Classes_Movie1.csv";
        String movieRatings = "data/Test_Classes_MovieRating1.csv";

        MediaLibrary media = new MediaLibrary();
        media.populateLibrary(song,movies,movieRatings);
        ArrayList<Ratable> actual = media.topKRatables(3);
        ArrayList<Ratable> expected = new ArrayList<>();

        Song song1 = new Song("Blinding Lights", "The Weeknd", "0VjIjW4GlUZAMYd2vXMi3b");
        song1.addRating(new Rating("18", 5));

        Song song2 = new Song("Chandelier","Sia","2s1sdSqGcKxpPr5lCl7jAV");
        song2.addRating(new Rating("59",4));

        ArrayList<String> cast = new ArrayList<>(Arrays.asList("Sylvester Stallone",
                "Talia Shire","Burt Young","Carl Weathers","Burgess Meredith",
                "Tony Burton","Mr. T","Hulk Hogan"))
                ;
        Movie movie1 = new Movie("Rocky III",cast);
        movie1.addRating(new Rating("1",2));



        expected.add(song1);
        expected.add(song2);
        expected.add(movie1);


        compareArrayRatable(expected,actual);


    }

    @Test
    public void testmedia2(){
        String song = "data/Test_Classes_Song1.csv";
        String movies = "data/Test_Classes_Movie1.csv";
        String movieRatings = "data/Test_Classes_MovieRating1.csv";

        MediaLibrary media = new MediaLibrary();
        media.populateLibrary(song,movies,movieRatings);


        ArrayList<Ratable> actual = media.topKRatables(100);
        ArrayList<Ratable> expected = new ArrayList<>();

        Song song1 = new Song("Blinding Lights", "The Weeknd", "0VjIjW4GlUZAMYd2vXMi3b");
        song1.addRating(new Rating("18", 5));

        Song song2 = new Song("Chandelier","Sia","2s1sdSqGcKxpPr5lCl7jAV");
        song2.addRating(new Rating("59",4));

        ArrayList<String> cast = new ArrayList<>(Arrays.asList("Sylvester Stallone",
                "Talia Shire","Burt Young","Carl Weathers","Burgess Meredith",
                "Tony Burton","Mr. T","Hulk Hogan"))
                ;
        Movie movie1 = new Movie("Rocky III",cast);
        movie1.addRating(new Rating("1",2));



        expected.add(song1);
        expected.add(song2);
        expected.add(movie1);
        System.out.println(expected);
        System.out.println(actual);

        compareArrayRatable(expected,actual);




    }

    @Test
    public void testmedia3(){
        String song = "data/Test_Classes_Song1.csv";
        String movies = "data/Test_Classes_Movie1.csv";
        String movieRatings = "data/Test_Classes_MovieRating1.csv";

        MediaLibrary media = new MediaLibrary();
        media.populateLibrary(song,movies,movieRatings);


        ArrayList<Ratable> actual = media.topKRatables(2);
        ArrayList<Ratable> expected = new ArrayList<>();

        Song song1 = new Song("Blinding Lights", "The Weeknd", "0VjIjW4GlUZAMYd2vXMi3b");
        song1.addRating(new Rating("18", 5));

        Song song2 = new Song("Chandelier","Sia","2s1sdSqGcKxpPr5lCl7jAV");
        song2.addRating(new Rating("59",4));

        ArrayList<String> cast = new ArrayList<>(Arrays.asList("Sylvester Stallone",
                "Talia Shire","Burt Young","Carl Weathers","Burgess Meredith",
                "Tony Burton","Mr. T","Hulk Hogan"))
                ;
        Movie movie1 = new Movie("Rocky III",cast);
        movie1.addRating(new Rating("1",2));




        expected.add(song1);
        expected.add(song2);
        expected.add(movie1);
        System.out.println(expected);
        System.out.println(actual);

        assertEquals(2,actual.size());


    }





}
