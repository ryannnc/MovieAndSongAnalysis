package ratings;

public class Reviewer {

    private String reviewerID;

    public Reviewer(String reviewerid){
        this.reviewerID = reviewerid;
    }
    public String getReviewerID(){
        return reviewerID;
    }

    public void setReviewerID(String reviewerid){
        this.reviewerID = reviewerid;
    }
    public Rating rateSong(int input){
        Rating name = new Rating(reviewerID,input);
        return name;
    }

}

//ratings.Reviewer - In the ratings package, Test a class named Reviewer
        //This class will have a constructor that takes 1 parameter:
        //A String representing the ID of the reviewer
        //Reviewer will have getter and setter methods for the constructor parameter named:
        //getReviewerID
        //setReviewerID
        //Implement a method named rateSong that takes an int as a
        //parameter and returns a reference to a new Rating object
        //(Using the Rating class described above) with this reviewer's ID
        // and the rating from the parameter of this method.