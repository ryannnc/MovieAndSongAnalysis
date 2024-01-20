package tests;

import org.junit.Test;
import ratings.Ratable;
import ratings.Rating;
import ratings.Reviewer;
import ratings.Song;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestClasses1 {
    @Test
    public void testSong() {
        Song song = new Song("lonely", "justin bieber", "1");

        assertEquals("lonely", song.getTitle());
        assertEquals("justin bieber", song.getArtist());
        assertEquals("1", song.getSongID());

        song.setTitle("jesus");
        assertEquals("jesus", song.getTitle());
        song.setArtist("boogie");
        assertEquals("boogie", song.getArtist());
        song.setSongID("2");
        assertEquals("2", song.getSongID());
    }

    @Test
    public void testReviewer() {
        Reviewer luffy = new Reviewer("Luffy");
        Reviewer chopper = new Reviewer("Chopper");

        assertTrue(luffy.getReviewerID().equals("Luffy"));

        luffy.setReviewerID("Zoro");
        assertTrue(luffy.getReviewerID().equals("Zoro"));

        Rating rate = luffy.rateSong(2);
        assertTrue(rate.getRating() == 2);
        assertTrue(rate.getReviewerID().equals("Zoro"));

        rate = luffy.rateSong(100);
        assertTrue(rate.getRating() == -1);

        assertTrue(chopper.getReviewerID().equals("Chopper"));
        Rating chopperrate = chopper.rateSong(3);
        assertTrue(chopperrate.getRating() == 3);

        chopperrate = chopper.rateSong(-3);
        assertTrue(chopperrate.getRating() == -1 );

    }

    @Test
    public void testRating() {
        Rating rate = new Rating("Luffy", 1);
        assertEquals("Luffy", rate.getReviewerID());
        assertTrue(rate.getReviewerID().equals("Luffy"));
        assertTrue(rate.getRating() == 1);

        rate.setRating(2);
        assertTrue(rate.getRating() == 2);
        rate.setRating(3);
        assertTrue(rate.getRating() == 3);
        rate.setRating(4);
        assertTrue(rate.getRating() == 4);
        rate.setRating(5);
        assertTrue(rate.getRating() == 5);
        rate.setRating(6);
        assertTrue(rate.getRating() == -1);
        rate.setRating(100);
        assertTrue(rate.getRating() == -1);
        rate.setRating(100000);
        assertTrue(rate.getRating() == -1);
        rate.setRating(0);
        assertTrue(rate.getRating() == -1);
        rate.setRating(-10000000);
        assertTrue(rate.getRating() == -1);
        rate.setRating(-10);
        assertTrue(rate.getRating() == -1 );

        rate = new Rating("Luffy", 0);
        assertTrue(rate.getRating() == -1);
        ;
        rate = new Rating("Luffy", 100);
        assertTrue(rate.getRating() == -1);

    }

}

