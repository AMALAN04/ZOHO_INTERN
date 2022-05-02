package taxi;

import java.util.ArrayList;
import java.util.List;

public class AvailableTaxi {

	public  List<Taxi> freeTaxis(List<Taxi> taxis,int pickupTime,int pickupPoint) //Divide available taxis into categories and add them to the new list
	{
		List<Taxi> freetaxis =new ArrayList<>();
		for(Taxi t:taxis) {
			if(t.getFreeTime() <= pickupTime &&Math.abs(pickupPoint-t.getCurrentSpot())<=(pickupTime-t.getFreeTime()))
			{
				freetaxis.add(t);
			}
			
		}
		if (freetaxis.size()==0)
		{
			System.out.println("** No Taxi Available **");
			return null;
			}
			return  freetaxis;	

		}

}
