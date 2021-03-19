//Rawan Alghamdi, 1806645, GBR
package gbr1806645p4_buytickets;

import java.util.Date;


public class Festival extends Event{
  
    private String[] FoodVenues;
    private String[] Activity;

    public Festival() {
       
    }
    public Festival( String Name, Date SDate, Date EDate, double Price, String City, String Address, String TragetedAudience, int AvailableTickets, String[] FoodVenues, String[] KidsActivity) {
        super(Name, SDate, EDate, Price, City, Address, TragetedAudience, AvailableTickets);
        this.FoodVenues = FoodVenues;
        this.Activity = KidsActivity;
    }

    public String getFoodVenues() {
        String food="";
        for (int i = 1; i < FoodVenues.length; i++) {
            if (i==1) {
             food +=FoodVenues[i].trim();   
            }else{
             food +=", "+FoodVenues[i].trim();}
              
        } 
        return food; 
    }

    public String getActivity() {
        String activity="";
        for (int i = 1; i < Activity.length; i++) {
          if (i==1) {
             activity +=Activity[i].trim();   
            }else{
             activity +=", "+Activity[i].trim();} 
        } 
        return activity;
    }

    public void setFoodVenues(String[] FoodVenues) {
        this.FoodVenues = FoodVenues;
    }

    public void setActivity(String[] Activity) {
        this.Activity = Activity;
    }
    
    
   

    @Override
     public int compareTo(Event o) {

    	if (o instanceof Festival){
    		return this.getSDate().compareTo(((Festival) o).getSDate());
    	}
    	return -2;

    }
    
    

    @Override
    public String toString() {
        return "AddingFestival{"+super.toString()+", FoodVenues: ["+getFoodVenues()+"], Activities: ["+getActivity()+"]} was successfully completed ";
    }
    
    
    
    
}
