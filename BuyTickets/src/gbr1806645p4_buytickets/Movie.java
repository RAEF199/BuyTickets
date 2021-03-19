//Rawan Alghamdi, 1806645, GBR
package gbr1806645p4_buytickets;

import java.util.Date;


public class Movie extends Event{
    
    private String Language;
    private double Rating;
    private String Genre;
    private Actor Actor;


    public Movie( String Name, Date SDate, Date EDate, double Price, String City, String Address, String Language, String TragetedAudience, double Rating, int AvailableTickets, String genre, Actor Actor) {
        super(Name, SDate, EDate, Price, City, Address, TragetedAudience, AvailableTickets);
        this.Language = Language;
        this.Rating = Rating;
        this.Genre =  genre;
        this.Actor = Actor;
    }

    public double getRating() {
        return Rating;
    }

    public String getGenre() {
        return Genre;
    }

    public Actor getActor() {
        return Actor;
    }

    public void setRating(double Rating) {
        this.Rating = Rating;
    }

    public void setGenre(String Genre) {
        this.Genre = Genre;
    }

    public void setActor(Actor Actor) {
        this.Actor = Actor;
    }

   /* public int compareTo(Event o){
      return 
   } */

    @Override
    
 public int compareTo(Event o) {
        if(o instanceof Movie){
        	if(((Movie) o).Rating > this.Rating){
        		return 1;
        	}else if(((Movie) o).Rating < this.Rating){
        		return -1;
        	}else {
        		return 0;}
        }
        return -2;
    }

    @Override
    public String toString() {
        return "AddingMovie{"+super.toString()+", Rating:"+Rating+", Language:"+Language+", Genre:"+getGenre().trim()+", Actor: "+getActor().getName()+" } was successfully completed";
    }
    
    
    
}
