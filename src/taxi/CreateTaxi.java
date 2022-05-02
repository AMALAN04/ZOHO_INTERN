package taxi;

import java.util.ArrayList;
import java.util.List;

public class CreateTaxi {
	public static List<Taxi> createtaxi(int n)	{     //Create new Taxi list
		List<Taxi> taxies =new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			 taxies.add(new Taxi()) ;
		}
	    return taxies;
	}

}
