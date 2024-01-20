package ratings;

import ratings.datastructures.LinkedListNode;

public class Ratable {
    private String title;
    private String artist;
    private String SongID;

    private LinkedListNode<Rating> Ratings;

    public Ratable(String title){
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public void addRating(Rating rated) {
        if (this.Ratings == null) {
            Ratings = new LinkedListNode(rated, null);
        } else {
            Ratings.append(rated);
        }

    }

    public LinkedListNode<Rating> getRatings() {
        if (this.Ratings == null) {
            return null;
        } else {
            return Ratings;
        }
    }

    public void setRatings(LinkedListNode<Rating> rate) {
        this.Ratings = rate;
    }

    public double averageRating() {
        if (this.Ratings == null) {
            return 0.0;
        }
        if (this.Ratings.size() == 0) {
            return 0.0;
        }
        double total = 0.0;
        int count = 0;
        LinkedListNode<Rating> head = Ratings;
        while (head != null) {
            if (head.getValue().getRating() != -1) {
                total += head.getValue().getRating();
                count += 1;
            }
            head = head.getNext();
        }
        if (count == 0) {
            return 0.0;
        }
        return total / count;
    }

    public void removeRatingByReviewer(Reviewer reviewerid) {
        String reviewer = reviewerid.getReviewerID();
        if (this.Ratings == null) {
            return;
        }
        if (this.Ratings.getValue().getReviewerID().equals(reviewer)) {
            this.Ratings = this.Ratings.getNext();
        }
        LinkedListNode<Rating> fire = this.Ratings;
        while (fire.getNext() != null) {
            if (fire.getNext().getValue().getReviewerID().equals(reviewer)) {
                fire.setNext(fire.getNext().getNext());
            } else {
                fire = fire.getNext();
            }

        }
    }

    public double bayesianAverageRating(int a, int b) {
        if (this.Ratings == null && a == 0) {
            return 0.0;
        //}  if ( a < 1 || b < 1 || b > 5){
            //return 0.0;
        } else if (this.Ratings == null){
            return (double)(a * b) / a ;
        }

        double total = 0.0;
        int count = a + Ratings.size() ;

        LinkedListNode<Rating> head = Ratings;
        while (head != null) {
                total += head.getValue().getRating();
                head = head.getNext();
        }
        total += (a * b);
        return total/count;

    }
}

