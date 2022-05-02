package taxi;

import java.util.Comparator;
 
public class MySort implements Comparator <Taxi>{ 
		public int compare(Taxi o1,Taxi o2){
			return (int)(o1.getTotalEarning() -o2.getTotalEarning());
		} 
}
