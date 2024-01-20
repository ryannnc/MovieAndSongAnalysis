package ratings;

public class Rating {
    private String ReviewerID;
    private int Rating;

    public Rating(String ID, int rating){
        if (rating > 5){
            this.Rating = -1;
        } else if (rating < 1){
            this.Rating = -1;
        } else {
            this.setReviewerID(ID);
            this.setRating(rating);
        }
    }

    public String getReviewerID(){
        return ReviewerID;
    }

    public void setReviewerID(String ReviewerID) {
        this.ReviewerID = ReviewerID;
    }

    public int getRating(){
        return Rating;
    }

    public void setRating(int Rating){
        if (Rating > 5){
            this.Rating = -1;
        }else if (Rating < 1){
            this.Rating = -1;
        } else {
            this.Rating = Rating;
        }
    }

    }




//ratings.Rating - In the ratings package, Test a class named Rating
        //This class will have a constructor that takes 2 parameters in this order:
        //A String representing the ID of the reviewer who gave the rating
        //An int representing the rating that the reviewer gave
        //Rating will have getter and setter methods for the two constructor parameters named:
        //getReviewerID
        //setReviewerID
        //getRating
        //setRating
        //Ratings must be in the range 1-5.
        //If someone calls setRatings with an invalid rating, the rating should be set to -1 to indicate that an error has occurred.
        //(eg. setRating(100) should result in the rating being set to -1).
        //This check must also apply when the constructor is called with an invalid rating.


