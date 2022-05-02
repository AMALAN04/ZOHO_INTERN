package taxi;

import java.util.HashMap;

public class Area {
	public HashMap<Integer,String> createArea()	{
	HashMap<Integer,String> areas = new HashMap<>();
	areas.put(1,"Mettur");
	areas.put(2,"Gv");
	areas.put(3,"Kolathur");
	areas.put(4,"Salem");
	return areas;
	}
	
	public void showArea()
	{
		System.out.println("1- Mettur");
	    System.out.println("2- Gv");
	    System.out.println("3- kolathur");
	    System.out.println("4- Salem");
	}

}
