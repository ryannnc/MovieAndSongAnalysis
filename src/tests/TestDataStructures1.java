package tests;

import org.junit.Test;
import ratings.Rating;
import ratings.Reviewer;
import ratings.Song;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import ratings.datastructures.LinkedListNode;
public class TestDataStructures1 {
    @Test
    public void testaverageRating(){
        Song test = new Song("Lonely","Justin","1");
        test.averageRating();
        assertEquals(0.0,test.averageRating(),0.001);

        test.addRating(new Rating("Luffy",2));
        assertEquals(2.0,test.averageRating(),0.001);

        test.addRating(new Rating("Zoro",5));
        assertEquals(3.5,test.averageRating(),0.001);

        test.addRating(new Rating("Zoro",5));
        assertEquals(4.0,test.averageRating(),0.001);

        Song wrong = new Song("NO","NOO","2");
        wrong.addRating(new Rating("L",-1));
        wrong.addRating(new Rating("V",-3));
        assertEquals(0.0,wrong.averageRating(),0.001);

        Song need = new Song("NO","NOO","2");
        need.averageRating();
        assertEquals(0.0,need.averageRating(),0.001);
        need.addRating(new Rating("V",-1));
        need.addRating(new Rating("OK",1));
        need.addRating(new Rating("Oasd",2));
        assertEquals(1.5,need.averageRating(),0.001);




    }
    @Test
    public void testRemoveRatingsByReviewer(){
        LinkedListNode<Rating> first = new LinkedListNode<>(new Rating("Luffy",2), null);
        first = new LinkedListNode<>(new Rating("Zoro",2), first);
        first = new LinkedListNode<>(new Rating("Garp",4), first);


        Song test = new Song("Lonely","Justin","1");

        test.addRating(new Rating("Luffy",2));
        test.addRating(new Rating("Zoro",2));
        test.addRating(new Rating("Sanji",1));
        test.addRating(new Rating("Chopper",5));
        test.addRating(new Rating("Tony",5));

        test.removeRatingByReviewer(new Reviewer("Luffy"));
        test.removeRatingByReviewer(new Reviewer("Zoro"));
        test.removeRatingByReviewer(new Reviewer("Tony"));

        test.addRating(new Rating("Killer",3));

        LinkedListNode<Rating> rated = test.getRatings();

        assertEquals(rated.size(), first.size());



    }
}

