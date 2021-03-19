//Rawan Alghamdi, 1806645, GBR
package gbr1806645p4_buytickets;

import java.text.SimpleDateFormat;
import java.util.*;

public class Customer {
   private String customerID;
   private String name;
   private char Gender;
   private String email;
   private Date DateOfBirth;
   private String city;

    public Customer() {
    }

   
   
    public Customer(String CID, String name, char Gender,String City, String email, Date DOB) {
        this.city=City;
        this.customerID = CID;
        this.name = name;
        this.Gender = Gender;
        this.email = email;
        this.DateOfBirth = DOB;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return Gender;
    }

    public String getEmail() {
        return email;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(char Gender) {
        this.Gender = Gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
    	SimpleDateFormat formatter =new SimpleDateFormat("dd/MM/yyy");
        return "AddingCustomerCustomer Number :"+customerID+" Name: "+name+", City: "+city+", Email: "+email.trim()+", BateOfBirth: "+formatter.format(getDateOfBirth())+"} was successfully completed ";
    }
   
   
   
}
