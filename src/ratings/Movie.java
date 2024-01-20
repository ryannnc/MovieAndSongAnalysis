package ratings;

import ratings.Rating;
import ratings.datastructures.LinkedListNode;

import java.util.ArrayList;

public class Movie extends Ratable {
    private String title;
    private ArrayList<String> cast;
    private LinkedListNode<Rating> Ratings;

    public Movie(String title, ArrayList<String> cast) {
        super(title);
        this.cast = cast;
    }


    public ArrayList<String> getCast() {
        return this.cast;
    }
}


