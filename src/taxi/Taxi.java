package taxi;

import java.util.LinkedList;
import java.util.List;

public class Taxi implements VehicleDetails
{
	private static int count = 1;
	private int id;       //Direct access for id is prevented
	private int currentSpot;
	private int freeTime;
	private int totalEarning;
    private boolean bookedStatus;
	private List<String> trips; 
	public Taxi( ){
		this.id = count ;
		this.currentSpot = 1;
		this.freeTime = 6;
		this.totalEarning = 0;
		this.bookedStatus = false;
		trips = new LinkedList<String>();
		count++;
	}
	public int getId()
	{
		return id;
	}
	public int getCurrentSpot()
	{
		return currentSpot;
	}
	public int getTotalEarning()
	{
		return totalEarning;
	}
	
	public int getFreeTime()
	{
		return freeTime;
	}
	public void setFreeTime(int freeTime)
	{
		this.freeTime = freeTime;
	}
	public List<String> getTrips() 
	{
		return trips;
	}
	public void setTrips(List<String> trips)
	{
		this.trips = trips;
	}
	public void removeTrips(int i)
	{
		trips.remove(i);
	}
	public void addTrips(int i,String newStr)
	{
		trips.add(i, newStr);
	}
	public void setCurrentSpot(int currentSpot) 
	{
		this.currentSpot = currentSpot;
	}
	public void setTotalEarning(int totalEarning) {
		this.totalEarning = totalEarning;
	}

	public void setDetails(boolean booked,int currentSpot,int freeTime,int totalEarnings,String tripDetail) { 
        this.bookedStatus = booked;
        this.currentSpot = currentSpot;
        this.freeTime = freeTime;
        this.totalEarning = totalEarnings;
        this.trips.add(tripDetail);
    }
	
}
