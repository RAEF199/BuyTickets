//Rawan Alghamdi, 1806645, GBR
package gbr1806645p4_buytickets;

import java.util.Date;


public class Concert extends Event {
    
    private String performers;

    public Concert() {
       
    }
    
    

    public Concert( String Name, Date SDate, Date EDate, String City, String Address, double Price, int AvailableTickets, String TragetedAudience, String performers) {
        super(Name, SDate, EDate, Price, City, Address, TragetedAudience, AvailableTickets);
        this.performers = performers;
    }

    public String getPerformers() {
        return performers;
    }

    public void setPerformers(String performers) {
        this.performers = performers;
    }

    @Override
    public int compareTo(Event o) {
    return -1;}

    
    @Override
    public String toString() {
        return "AddingConcert{"+super.toString()+", Performers: "+performers+"} was successfully completed "; 
    
  /* public int compareTo(Event o){
      return 
   } */}
    
    
    
    
    
    
    
}
