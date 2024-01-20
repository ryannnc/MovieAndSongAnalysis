package ratings;

import ratings.datastructures.SongBayesianRatingComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MediaLibrary {
    private ArrayList<Ratable> ratables ;

    public MediaLibrary(){
        ratables = new ArrayList<>();

    }

    public void populateLibrary(String songrating, String movie, String movierating){
        ArrayList<Song> song = FileReader.readSongs(songrating);
        ratables.addAll(song);
        ArrayList<Movie> movies = FileReader.readMovies(movie);
        ArrayList<Movie> moviesratings = FileReader.readMovieRatings(movies, movierating);
        ratables.addAll(moviesratings);


    }

    public ArrayList<Ratable> topKRatables(int k) {
        ArrayList<Ratable> list = new ArrayList<>(ratables);

        for (int x = 1; x < list.size(); x++) {
            Ratable value = list.get(x);
            int y = x ;
            while (y > 0 && list.get(y - 1).bayesianAverageRating(2, 3) < value.bayesianAverageRating(2, 3)) {
                list.set(y, list.get(y - 1));
                y = y - 1 ;
            }
            list.set(y, value);
        }
        ArrayList<Ratable> results = new ArrayList<>();
        for (int x = 0; x < k && x < list.size(); x++) {
            results.add(list.get(x));
        }

        return results;
    }
}


