//Rawan Alghamdi, 1806645, GBR
package gbr1806645p4_buytickets;
 import java.util.*;
import java.text.SimpleDateFormat;
public abstract class Event implements Comparable<Event>{
    private String Name;
    private Date SDate;
    private Date EDate;
    private double Price;
    private String City;
    private String Address;
    private String TragetedAudience;

    public Event() {
    }
    private int AvailableTickets;

   
   

    public Event(String Name, Date SDate, Date EDate, double Price, String City, String Address, String TragetedAudience, int AvailableTickets) {
        this.Name = Name;
        this.SDate = SDate;
        this.EDate = EDate;
        this.Price = Price;
        this.City = City;
        this.Address = Address;
        this.TragetedAudience = TragetedAudience;
        this.AvailableTickets = AvailableTickets;
    }

    public String getName() {
        return Name;
    }

    public Date getSDate() {
        return SDate;
    }

    public Date getEDate() {
        return EDate;
    }

    public double getPrice() {
        return Price;
    }

    public String getCity() {
        return City;
    }

    public String getAddress() {
        return Address;
    }

    public String getTragetedAudience() {
        return TragetedAudience;
    }

    public int getAvailableTickets() {
        return AvailableTickets;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setSDate(Date SDate) {
        this.SDate = SDate;
    }

    public void setEDate(Date EDate) {
        this.EDate = EDate;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setTragetedAudience(String TragetedAudience) {
        this.TragetedAudience = TragetedAudience;
    }

    public void setAvailableTickets(int AvailableTickets) {
        this.AvailableTickets = AvailableTickets;
    }

    @Override
    public String toString() {

    	SimpleDateFormat formatter =new SimpleDateFormat("dd/MM/yyy");
       return  "Name:" + Name + ", Dates:" + formatter.format(getSDate())+ "-" + formatter.format(getEDate()) +", City:" + City + ", Address:" + Address + ", Price:" + Price + ", Target Audience: " + TragetedAudience + ", Tickets Available: " + AvailableTickets ;

   }
    
    
    
}
