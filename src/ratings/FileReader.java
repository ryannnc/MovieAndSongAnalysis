package ratings;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
public class FileReader {

    public static ArrayList<String> readFile(String filename) {
        try {
            return new ArrayList<>(Files.readAllLines(Paths.get(filename)));
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public static ArrayList<Song> readSongs(String filename) {
        ArrayList<Song> songs = new ArrayList<>();
        ArrayList<String> lines = readFile(filename);

        for (String line : lines) {
            ArrayList<String> splits = new ArrayList<>(Arrays.asList(line.split(",")));

            String songID = splits.get(0);
            String artist = splits.get(1);
            String title = splits.get(2);
            String reviewerID = splits.get(3);
            int rating = Integer.parseInt(splits.get(4));
            Song song = new Song(title, artist, songID);
            Rating rate = new Rating(reviewerID, rating);


            boolean list = false;
            for (Song s : songs) {
                if (s.getSongID().equals(song.getSongID()) &&
                        s.getArtist().equals(song.getArtist()) &&
                        s.getTitle().equals(song.getTitle())) {
                    s.addRating(rate);
                    list = true;
                    break;
                }
            }
            if (!list) {
                Song song1 = new Song(title, artist, songID);
                song1.addRating(rate);
                songs.add(song1);
            }
        }
        return songs;

    }

    public static ArrayList<Movie> readMovies(String filename) {
        ArrayList<Movie> movies = new ArrayList<>();
        ArrayList<String> lines = readFile(filename);
        for (String line : lines) {
            ArrayList<String> splits = new ArrayList<>(Arrays.asList(line.split(",")));
            String title = splits.get(0);
            ArrayList<String> cast = new ArrayList<>();
            for (int i = 1; i < splits.size(); i++) {
                cast.add(splits.get(i));
            }
            movies.add(new Movie(title, cast));
        }
        return movies;
    }

    public static ArrayList<Movie> readMovieRatings(ArrayList<Movie> movies, String filename) {
        HashMap<String, Movie> map = new HashMap<>();
        ArrayList<Movie> moviesWithRatings = new ArrayList<>();

        for (Movie m : movies) {
            map.put(m.getTitle(), m);
        }

        ArrayList<String> lines = readFile(filename);
        for (String line : lines) {
            ArrayList<String> splits = new ArrayList<>(Arrays.asList(line.split(",")));
            String title = splits.get(0);
            String reviewerid = splits.get(1);
            int rating = Integer.parseInt(splits.get(2));
            Rating rated = new Rating(reviewerid, rating);
            if (map.containsKey(title)) {
                map.get(title).addRating(rated);
            }
        }

        for (Movie movie : map.values()) {
            if (movie.getRatings() != null) {
                moviesWithRatings.add(movie);
            }
        }

        return moviesWithRatings;
    }
}

   // public static HashMap<String, ArrayList<City>> loadCountries(String filename){
       // HashMap<String, ArrayList<City>> countries = new HashMap<>();
       // ArrayList<String> lines = readFile(filename);
       // lines.remove(0);
       // for (String line : lines) {
          //  ArrayList<String> splits = new ArrayList<>(Arrays.asList(line.split(",")));

            //String country = splits.get(0);
            //String name = splits.get(1);
            //String region = splits.get(2);
            //int population = Integer.parseInt(splits.get(3));
            //double latitude = Double.parseDouble(splits.get(4));
            //double longitude = Double.parseDouble(splits.get(5));
            //Location location = new Location(latitude, longitude);
            //City city = new City(name, region, country, population, location);
            //if(!countries.containsKey(country)){
                //countries.put(country, new ArrayList<>());
            //}
            //countries.get(country).add(city);
        //}
        //return countries;




