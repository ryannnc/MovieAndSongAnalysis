package ratings;

import ratings.datastructures.LinkedListNode;

public class Song extends Ratable{
    private String title;
    private String artist;
    private String SongID;

    private LinkedListNode<Rating> Ratings;

    public Song(String title, String artist, String SongID) {
        super(title);
        this.setArtist(artist);
        this.setSongID(SongID);

    }
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSongID() {
        return SongID;
    }

    public void setSongID(String SongID) {
        this.SongID = SongID;
    }


}





//ratings.Song - In the ratings package, test a class named Song
        //This class will have a constructor that takes 3 parameters in this order:
        //A String representing the title of the Song
        //A String representing the artist of the Song
        //A String representing the Songs ID
        //Song will have getter and setter methods for the three constructor parameters named:
        //getTitle
        //setTitle
        //getArtist
        //setArtist
        //getSongID <-- Note that both characters in ID are capital
        //setSongID
        //For this task,
        //you don't need to implement any additional methods in the Song class
        //(We will add to this class in later tasks)
