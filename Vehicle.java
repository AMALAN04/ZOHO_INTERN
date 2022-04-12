package rapWido;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class Vehicle 
{
 
 public abstract void setDetails(boolean booked,int currentSpot,int freeTime,int totalEarnings,String tripDetail);
     
  public abstract void printDetails();
     
  public abstract void printVehicleDetails();
     

}
class TaxiTicket extends Vehicle
{
	static int count = 1;
	int id;
	int currentSpot;
	int freeTime;
	int totalEarning;
    boolean bookedStatus;
	List<String> trips;  
	public TaxiTicket( )
	{
		
		this.id = count ;
		this.currentSpot = 1;
		this.freeTime = 6;
		this.totalEarning = 0;
		this.bookedStatus = false;
		trips = new LinkedList<String>();
		count++;
	}
	
 

	 
	public void setDetails(boolean booked,int currentSpot,int freeTime,int totalEarnings,String tripDetail)
	    {
	            this.bookedStatus = booked;
	            this.currentSpot = currentSpot;
	            this.freeTime = freeTime;
	            this.totalEarning = totalEarnings;
	            this.trips.add(tripDetail);
	    }
	  public void printDetails()
	    {
	        System.out.println("Taxi - "+ this.id + " Total Earnings - " + this.totalEarning);
	        System.out.println("TaxiID    BookingID    CustomerID    From    To    PickupTime    DropTime    Amount");
	        for(String trip : trips)
	        {
	            System.out.println(id + "          " + trip);
	        }
	        System.out.println("--------------------------------------------------------------------------------------");
	    }
	  public void printVehicleDetails()
	    {
	        System.out.println("Taxi - "+ this.id + " Total Earnings - " + this.totalEarning + " Current spot - " + this.currentSpot +" Free Time - " + this.freeTime);
	        System.out.println("----------------------------------------------------------------------------------------");
	        
	    }

	
}

 

