package taxi;

public abstract class Vehicle 
{
 
	  public abstract void setDetails(boolean booked,int currentSpot,int freeTime,int totalEarnings,String tripDetail);
	     
	  public abstract void printDetails();
	     
	  public abstract void printVehicleDetails();
}
