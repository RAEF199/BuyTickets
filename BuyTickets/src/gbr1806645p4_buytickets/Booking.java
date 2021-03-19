//Rawan Alghamdi, 1806645, GBR
package gbr1806645p4_buytickets;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Booking {
   private String BookingID;
   private Customer Customer;
   private ArrayList<Event> events;
   private double discount;
   private double finalTotalPrice;
   //for number of discount event 
   private int count=0;

    public Booking(String BookingID, Customer Customer, ArrayList<Event> events) {
        
        this.BookingID = BookingID;
        this.Customer = Customer;
        this.events = events;
    }

    public Booking() {
		// TODO Auto-generated constructor stub
	}

	public Customer getCustomer() {
        return Customer;
    }

    public void setCustomer(Customer Customer) {
        this.Customer = Customer;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }
    
    public String getBookingID() {
        return BookingID;
    }

    public void setBookingID(String BookingID) {
        this.BookingID = BookingID;
    }
   
    public double getDiscount() {
    	 //calculate age 
   	 int age=0;
   	  SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
   	  Date currentDate= new Date();
  	      String cd=formatter.format(currentDate);
  	      age= currentDate.getYear()-getCustomer().getDateOfBirth().getYear();
  	      if(age <= 3){
  	    	//discount= getTotalPrice()-(getTotalPrice()* 1);
  	    	discount=1.0;
  	       } else if(age <=15){
  	    	//discount= getTotalPrice()-(getTotalPrice()* 0.50);
  	    	 discount=0.50;
  	       }else {
  	    	//discount= getTotalPrice();  
  	    	 discount=0.0;
  	       }
       
        return discount;
    }
    public double getDiscount(Event event) {
    	count=0;
    	if(event instanceof Festival){
    	discount= getDiscount();
    	} 
    	if(discount>0.0)
    		count++;
        return discount;     
    }
    public double getFinalPrice(Event event) {
    	finalTotalPrice=event.getPrice() - (event.getPrice()*getDiscount(event));
           return finalTotalPrice;
      }	
  //calculate price without dis
    public double getTotalPrice() {
    	finalTotalPrice=0.0;
    	for(int i=0; i< getEvents().size(); i++){
    		finalTotalPrice += getEvents().get(i).getPrice();
    		}
        return finalTotalPrice;
    }
  //calculate price with dis
    public double claculateFinalPrice() {
    	double price=0.0;
    	double dis=0.0;
    	price=getTotalPrice();
    	for(int i=0; i< getEvents().size(); i++){
    		if(getEvents().get(i) instanceof Festival){
    		dis=getEvents().get(i).getPrice()*getDiscount(getEvents().get(i));
    		}
    		}
   	 
     return finalTotalPrice=price-dis ;
   }

   public int getNumberOfDiscountEvents() {
	   
	    return count;
    }
      
    public double getSavingAmount() {
    	double saving= getTotalPrice() - claculateFinalPrice();
    	return saving;
    }

    @Override
    public String toString() {
     return "Booking# "+getBookingID();
    }
      
    
}
