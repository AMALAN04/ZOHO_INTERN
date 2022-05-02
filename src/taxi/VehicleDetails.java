package taxi;

import java.util.List;

public interface VehicleDetails {
	public int getId();
	public int getCurrentSpot();
	public int getTotalEarning();
	public int getFreeTime();
	public void setFreeTime(int freeTime);
	public List<String> getTrips();
	public void setTrips(List<String> trips);
	public void removeTrips(int i);
	public void addTrips(int i,String newStr);
	public void setCurrentSpot(int currentSpot);
	public void setTotalEarning(int totalEarning);
	public abstract void setDetails(boolean booked,int currentSpot,int freeTime,int totalEarnings,String tripDetail); 

}
