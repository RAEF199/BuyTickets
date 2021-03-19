//Rawan Alghamdi, 1806645, GBR
package gbr1806645p4_buytickets;
import java.util.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period; 
public class GBR1806645P4_BuyTickets{

   static SimpleDateFormat formatter =new SimpleDateFormat("dd/MM/yyy"); 
    public static void main(String[] args)throws Exception {
        //check the file 
        File input = new File("input.txt");
        if (!input.exists())
           System.out.println("the file doesn't exist");
        //make scanner to read from file
        Scanner read1 = new Scanner(input);
        Scanner read2 = new Scanner(input);
        //make file to write into 
        File output = new File("output.txt");
        //printwriter to write into the file 
        PrintWriter write = new PrintWriter(output);
        PrintWriter write1 = new PrintWriter(output);
        ArrayList<Event> event = new ArrayList<>();
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<String> eventName = new ArrayList<>();
        ArrayList<Date> dates = new ArrayList<>();
        String customerName="";
        int counter=1;
        //to read from file and implement the commands
        while(read1.hasNext()){
        String[] command1 = read1.nextLine().split("--");
        
        if(command1[0].equalsIgnoreCase("AddMovie")){
        String[] com = command1[1].split(",");
        event.add(getMovie(read1, com));
        }
        
        if(command1[0].equalsIgnoreCase("AddFestival")){
         String[] com = command1[1].split(",");
         event.add(getFestival(read1, com)); 
        }
     
        if(command1[0].equalsIgnoreCase("AddConcert")){
         String[] com = command1[1].split(",");
         event.add(getConcert(read1, com)); 
        }
        
        if(command1[0].equalsIgnoreCase("AddCustomer")){
         String[] com = command1[1].split(",");
         customers.add(getCustomer(read1, com,counter)); 
         counter++;
        }
       }
        //to print add command into output file
        PrintAddCommand(write,customers, event );
        
        //read command buy ticket
        while(read2.hasNext()){
        String[] command1 = read2.nextLine().split("--");   
        if(command1[0].equalsIgnoreCase("BuyTicket")){
        
           String[] com = command1[1].split(",");
           String name = com[0];
           eventName.add(name);
           SimpleDateFormat formatter =new SimpleDateFormat("dd/MM/yyy");
           Date bookingDate = formatter.parse(com[1]);
           dates.add(bookingDate);
        }
         if(command1[0].equalsIgnoreCase("For")){
            String[] com = command1[1].split(",");
            customerName = com[0];
       }
         if(command1[0].equalsIgnoreCase("Submit")){
        	 checkAvalibleEvent(event,customers, eventName, dates, customerName, write );
        	 eventName.clear();
        	 dates.clear();
         }   
         
        if(command1[0].equalsIgnoreCase("PrintSortMovies")){
        	 Collections.sort(event);
                 PrintSortMovies(write,event);
        }
        if(command1[0].equalsIgnoreCase("PrintSortFestivals")){
       	         Collections.sort(event);
       	         PrintSortFestivals(write,event);
       }   
      }
         //close write
         write.close();   
    }
    
private static Event getMovie(Scanner read1, String com[])throws Exception{
       String Name =com[0];
        Date SDate= formatter.parse(com[1]); 
        Date EDate= formatter.parse(com[2]);
        double Price = Double.parseDouble(com[3].trim());
        String City = com[4];
        String Address = com[5]; 
        String Language = com[6];
        String TragetedAudience = com[7];
        double Rating  = Double.parseDouble(com[8].trim());
        int AvailableTickets = Integer.valueOf(com[9].trim()); 
        String genre = com[10];
        String name = com[11];
        char Gender = com[12].charAt(0);
        int Birthyear= Integer.valueOf(com[13].trim()); 
        Actor actor = new Actor( name, Gender, Birthyear);
        actor.setName(name);
        actor.setGender(Gender);
        actor.setBirthyear(Birthyear);
        Event movie= new Movie( Name, SDate,  EDate, Price,  City, Address, Language,TragetedAudience,Rating,  AvailableTickets, genre, actor);
        return movie;
    }

private static Event getFestival(Scanner read1, String com[]) throws ParseException{
        String Name =com[0];
        String date1[]=com[1].split("/");
        int day1 = Integer.parseInt(date1[0].trim());    
        int month1= Integer.parseInt(date1[1].trim()); 
        int year1= Integer.parseInt(date1[2].trim()); 
        Date SDate= formatter.parse(com[1]);
        String date2[]=com[2].split("/");
        int day2 = Integer.parseInt(date2[0].trim());    
        int month2 = Integer.parseInt(date2[1].trim()); 
        int year2 = Integer.parseInt(date2[2].trim()); 
        Date EDate= formatter.parse(com[2]);
        double Price = Double.parseDouble(com[3].trim());
        String City = com[4];
        String Address = com[5]; 
        String TragetedAudience = com[6];
        int AvailableTickets = Integer.parseInt(com[7].trim());
        String FoodVenues[] = com[8].split("\\s");
        String KidsActivity[] = com[9].split("\\s");
        Event festival = new Festival( Name, SDate, EDate,  Price, City,  Address, TragetedAudience,  AvailableTickets, FoodVenues, KidsActivity);
        return festival;
}

private static Event getConcert(Scanner read1, String com[]) throws ParseException{
        String Name =com[0];
        String date1[]=com[1].split("/");
        int day1 = Integer.parseInt(date1[0].trim());    
        int month1= Integer.parseInt(date1[1].trim()); 
        int year1= Integer.parseInt(date1[2].trim()); 
        Date SDate= formatter.parse(com[1]);
        String date2[]=com[2].split("/");
        int day2 = Integer.parseInt(date2[0].trim());    
        int month2 = Integer.parseInt(date2[1].trim()); 
        int year2 = Integer.parseInt(date2[2].trim()); 
        Date EDate= formatter.parse(com[2]);
        String City = com[3];
        String Address = com[4]; 
        double Price = Double.parseDouble(com[5].trim());
        int AvailableTickets = Integer.valueOf(com[6].trim());
        String TragetedAudience = com[7];
        String performers = com[8];
        Event concert = new Concert( Name,SDate,EDate,City,Address,Price,AvailableTickets,TragetedAudience, performers) ;
       return concert;  
}

private static Customer getCustomer(Scanner read1, String com[], int counter) throws ParseException{
    String customerID = "00000"+counter; 
    String CustomerName= com[0];
    char Gender  = com[1].charAt(0);
    String City = com[2];
    String date1[]=com[3].split("/");
    int day1 = Integer.parseInt(date1[0].trim());    
    int month1 = Integer.parseInt(date1[1].trim()); 
    int year1 = Integer.parseInt(date1[2].trim()); 
    Date DateOfBirth= formatter.parse(com[3]);
    String email = com[4];
    return new Customer(customerID, CustomerName, Gender, City, email,  DateOfBirth);
}

private static boolean checkAvalibleEvent(  ArrayList<Event> event,ArrayList<Customer> customer, ArrayList<String> eventName, ArrayList<Date> dates,String customerName, PrintWriter write){
	 ArrayList<Event> bookedEvents = new ArrayList<Event>();
	 int items=0;
         SimpleDateFormat formatter =new SimpleDateFormat("dd/MM/yyy");
	for (int i=0; i<eventName.size(); i++){
	    for(int j=0; j<event.size(); j++){
	       if(eventName.get(i).equals(event.get(j).getName())) {
	           if(dates.get(i).getTime()>= event.get(j).getSDate().getTime() && dates.get(i).getTime() <= event.get(j).getEDate().getTime()){
                      items++; 
                      write.println("The requested event " + event.get(j).getName() + 
               	         	 " is available in the selected date \nTicket is successfully added to the ShoppingCart: Cart Size -> "+ items);	
                      bookedEvents.add(event.get(j));
                      event.get(j).setAvailableTickets(event.get(j).getAvailableTickets()-1);
                      break;
		   }else {write.println(	"The requested event " + event.get(j).getName() + 
          	         " is not available in the selected date \nTicket not successfully added to the ShoppingCart: Cart Size -> "+ items);	
          	}
	     }	
	   }
	}
	//compare customer name and create book object 
	String bookingID="";
        // Generate random integers in range 0 to 999 
        int rand_int1 = (int)(100+Math.random()*1000); 
	int foundindex=0;
	boolean found=false;
	for (int i=0; i<customer.size(); i++){
           if(customer.get(i).getName().equals(customerName)){
               foundindex=i;
               found=true;
	       break;
          }	      
	}
   if(found){
        write.println("**Buying Ticket for "+ customerName +" was successfully completed");
        bookingID=customer.get(foundindex).getCustomerID()+rand_int1;
        Booking book= new Booking(bookingID,customer.get(foundindex), bookedEvents);
        //to print the bill
        PrintInformation(book,write,bookingID,customer.get(foundindex).getCustomerID(), bookedEvents);
   }else write.println("The customer "+ customerName+" is not found \r\n **Buying Ticket for was not successfully completed\r\n");
return true;}

private static void PrintAddCommand(PrintWriter write, ArrayList customer, ArrayList<Event> event){
    write.println();
    write.println("########################################################################################################\r\n" +
"############################# Welcome to Entertainment Booking System ##################################\r\n" +
"########################################################################################################");
    write.println();
    for (int i = 0; i < event.size(); i++) {
        write.println(event.get(i).toString());
    }
    for (int i = 0; i < customer.size(); i++) {
        write.println(customer.get(i).toString());
    }
}

private static void PrintInformation(Booking book, PrintWriter write, String bookingID, String customerID, ArrayList<Event> bookedEvents ){
   int numberOfDiscount = 0;
   write.println("\r\n------------------------- Invoice Details -------------------------");
   write.println(book.toString());
   write.println("Customer #: "+customerID);
   write.println("-------------------------------------------------------------------");
   write.println("Event               	Price   	Discount	Final_price");
    for (int i=0; i<bookedEvents.size(); i++){
           char percent = '%';
	   write.printf("%-24s%-16.2f%.1f%-13c%.2f\r\n",bookedEvents.get(i).getName(),bookedEvents.get(i).getPrice(),book.getDiscount(bookedEvents.get(i))*100,percent,book.getFinalPrice(bookedEvents.get(i)));
           }
   write.println("-------------------------------------------------------------------");
   write.println("Number of discount items: " + book.getNumberOfDiscountEvents()); 
   write.printf("- Total Price: %.2f\r\n", book.getTotalPrice());
   write.printf("- Final Price: %.2f\r\n", book.claculateFinalPrice());
   write.printf("- Saving Amount: %.2f\r\n", book.getSavingAmount());
   write.println("-------------------------------------------------------------------\r\n\r\n"); 
}

private static void PrintSortMovies(PrintWriter write, ArrayList<Event> event){
SimpleDateFormat formatter =new SimpleDateFormat("dd/MM/yy");
Movie [] movies= new Movie [6];
int j=0;
  write.println("----------------------------------------- Movie Sorted By Rating ------------------------------------------");
  write.println("Movie name          	Dates               	Actor             	Ratings       Available Tickets");
  write.println("---------------------------------------------------------------------------------------------------------");
    for (int i = 0; i < event.size(); i++) {
    	if( event.get(i) instanceof Movie){
    		movies[j]=(Movie) event.get(i);
    		j++;
    	}
    }
   for (int i = 0; i < movies.length; i++) {
    	 char dash = '-';
         write.printf("%-17s      %s%c%s      %-25s   %-15.1f    %-15d \r\n",movies[i].getName(),formatter.format(movies[i].getSDate()),dash,formatter.format(movies[i].getEDate()),movies[i].getActor().getName(),movies[i].getRating(),movies[i].getAvailableTickets());
    }
   write.println("---------------------------------------------------------------------------------------------------------");
   write.println();
   write.println();
}

private static void PrintSortFestivals(PrintWriter write, ArrayList<Event> event){
	
	SimpleDateFormat formatter =new SimpleDateFormat("dd/MM/yy");
	//to calculate available tickets
	  write.println("----------------------------------------- Festival Sorted By Starting Date  ------------------------------------------------------------------------");
	  write.println("Festival Name              	  Dates               	    FoodVenues               	    Activities         Available Tickets   ");
	  write.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
	  Festival [] festivals= new Festival [6];
		  int j=0;
		  for (int i = 0; i < event.size(); i++) {
		    	if( event.get(i) instanceof Festival){
		    		festivals[j]=(Festival) event.get(i);
		    		j++;
		    	}
		    }
		   for (int i = 0; i < festivals.length; i++) {
		    	 char dash = '-';
		    	 char pract1='[';
		    	 char pract2=']';
		         write.printf("%-23s      %s%c%s      %c%s%-20c  %c%s%-15c    %d \r\n",festivals[i].getName(),formatter.format(festivals[i].getSDate()),dash,formatter.format(festivals[i].getEDate()),pract1, festivals[i].getFoodVenues(),pract2,pract1,festivals[i].getActivity(),pract2, festivals[i].getAvailableTickets());
		    }
		   write.println("---------------------------------------------------------------------------------------------------------------------------------------");
		   write.println();
		   write.println(); 
}


}
