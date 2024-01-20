package ratings.datastructures;

import ratings.Song;

public class SongBayesianRatingComparator extends Comparator<Song>{


    public boolean compare(Song a, Song b) {
        double average = a.bayesianAverageRating(2,3);
        double average2 = b.bayesianAverageRating(2,3);
        if(average > average2){
            return true ;
        } else {
            return false;
        }
    }
}
