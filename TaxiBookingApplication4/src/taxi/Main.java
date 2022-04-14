/************************************************************************************************************************************
-There are 4 taxi’s.
-The are 4 points(“Mettur”, “ Gv”, “Kolathur” ,“Salem”).
-All the points are in a straight line, and each point is 15kms away from the adjacent points.
-It takes 60 mins to travel from one point to another
-Each taxi charges Rs.100 minimum for the first 5 kilometers and Rs.10 for the subsequent
kilometers.
-For simplicity, time can be entered as absolute time.
-All taxi’s are initially stationed at “Mettur” and available from 6Am.
-When a customer books a Taxi, a free taxi at that point is allocated
-If no free taxi is available at that point, a free taxi at the nearest point is allocated.
-If two taxi’s are free at the same point, one with lower earning is allocated.
- If the customer wanted to cancel the ticket, Rs 15 is charged as a fine.

No.of.Class - 7

class Area -> Used to create new areas

Class Taxi ->  Holds taxi details extends Vehicle class;

class AvailabeTaxi ->  Create new taxis and add them to a linked list. Divide available taxis into categories and add them to the new list.

class TaxiTicketBooking -> Ticket Booking and Cancelling.

Class MySort -> Sort available taxis based their total earning.

abstract class Vehicle -> Holds details related to vehicles.

No.of.interface - 2

interface TicketBooking

interface GenerateOTP

****************************************************************************************************************************************/
package taxi;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
public class Main extends TaxiTicketBooking 
{
	 
		public static void main(String[] args) 
		{
			TaxiTicketBooking customer = new TaxiTicketBooking();
			List<Taxi> taxis = createtaxi(4);
			int id=1;
			int customerChoice =0;
			boolean bookedStatus; 
			int customerId =id;
			int pickupTime =0;
			int pickupPoint =0;
		    int dropPoint =0;
		    HashMap<Integer,String> areas =new Area().createArea();
			boolean x = true;
			
			while(x)
			{
			System.out.println("1- Book Ticket");
		    System.out.println("2- Taxi List");
		    System.out.println("3- Cancel");
		    System.out.println("4- Exit");
			Scanner input = new Scanner(System.in);
			customerChoice = input.nextInt();
			switch (customerChoice)
			{
			case 1:
			{
				customerId =id;
				System.out.println("1- Mettur");
			    System.out.println("2- Gv");
			    System.out.println("3- kolathur");
			    System.out.println("4- Salem");
			    System.out.println("Enter the Pickup and Drop point");
			    pickupPoint = input.nextInt();
			    dropPoint = input.nextInt();
			    if(pickupPoint >4 || pickupPoint <0)
			    {
			    	System.out.println("Enter a Valid PickUp Point");
			    	pickupPoint = input.nextInt();
			    	
			    }
			    if(dropPoint >4 || dropPoint <0)
			    {
			    	System.out.println("Enter a Valid Drop point");
			    	dropPoint = input.nextInt();
			    }
			    System.out.println("Enter the Pickup time");
			    pickupTime = input.nextInt();
			    bookedStatus = customer.bookticket(customerId,pickupPoint,dropPoint,pickupTime,areas,taxis);
			    if(bookedStatus)
			    id++;
		        break;
			}
			case 2:
	        {
	            
	             for(Taxi t : taxis)
	                t.printVehicleDetails();
	             for(Taxi t : taxis)
	                t.printDetails();
	            break;
	        }
	        
	        
			case 3:
			{
				System.out.println("**Enter Customer id**");
				String searchId = input.next();
				customer.cancel(searchId,taxis);
				
				
				break;
			} 
			case 4:
			{
				System.out.println("**Thank You**");
				
				return;
			}
	        default:
	        {
	        	System.out.println("Choose a valid key");
	        }
	            
			}
			}
		}
}
