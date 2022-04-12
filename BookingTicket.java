package rapWido;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

 
class Mysort implements Comparator<TaxiTicket>
{
	public int compare(TaxiTicket o1,TaxiTicket o2)
	{
		return (int)(o1.totalEarning -o2.totalEarning);
	}
}

class Ticket  
{
	static int numeric =0;
	private static int x;
	public static void  bookticket(int customerId,int pickupPoint,int dropPoint,int pickupTime,List<TaxiTicket> freeTaxis)
	{
	 int min=1000;
	 TaxiTicket bookedTaxi=null;
	 int newFreeTime=6;
	 int currentSpot=0;
	 int earning=0;
	 String tripDetails="";
	 int distanceBetweenpickUpandDrop = 0;
	 
	 for(TaxiTicket t : freeTaxis)
     {
         int distanceBetweenCustomerAndTaxi = Math.abs((t.currentSpot - '0') - (pickupPoint - '0')) * 15;
         if(distanceBetweenCustomerAndTaxi < min)
         {
             bookedTaxi = t;
              
             distanceBetweenpickUpandDrop = Math.abs((dropPoint) - (pickupPoint)) * 15;
              
             earning = (distanceBetweenpickUpandDrop-5) * 10 + 100;
             
             int dropTime  = pickupTime + distanceBetweenpickUpandDrop/15;
             newFreeTime = dropTime;

             currentSpot = dropPoint;

             tripDetails = customerId + "               " + customerId + "          " + pickupPoint +  "      " + dropPoint + "       " + pickupTime + "          " +dropTime + "           " + earning;
             min = distanceBetweenCustomerAndTaxi;
         }
		 
	}
	 x=bookedTaxi.id;
	 
	 bookedTaxi.setDetails(true, currentSpot,  newFreeTime,bookedTaxi.totalEarning + earning,tripDetails);
	 System.out.println("Taxi " + bookedTaxi.id + " booked");
		 
	
	 
	}
	public static void generateOtp(int customerId,int pickupPoint,int dropPoint,int pickupTime,HashMap<Integer,String> area)
	{
	   
		int amount = ((Math.abs((dropPoint) - (pickupPoint)) * 15)-5)*10+100;
		System.out.println("------------------------------------------------------------------------------------");
		
		System.out.println("Customer Id : " + customerId );
		System.out.println("Pickup Point : " + area.get(pickupPoint) );
		System.out.println("DropPoint : " + area.get(dropPoint) );
		System.out.println("Pickup Time: " + pickupTime );
		String OTP =""+customerId +pickupPoint+dropPoint +x;
		System.out.println("OTP : " + OTP );
		System.out.println("Cost : " + amount+" Rs" );
		System.out.println("------------------------------------------------------------------------------------");
	
		
		
		
	}
	
	
	public static void generateOtp(int customerId,int pickupPoint,int dropPoint,int pickupTime,HashMap<Integer,String> area,String name)
	{
		int amount = (Math.abs((dropPoint) - (pickupPoint)) * 15)*8;
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("** " + name + " **" );
		System.out.println("Customer Id : " + customerId );
		System.out.println("Pickup Point : " + area.get(pickupPoint) );
		System.out.println("Drop Point : " + area.get(dropPoint) );
		System.out.println("Pickup Time : " + pickupTime );
		System.out.println("Cost : " + amount+" Rs" );
		String OTP =""+customerId +"R"+numeric+pickupPoint+dropPoint;
		System.out.println("OTP : " + OTP );
		System.out.println("------------------------------------------------------------------------------------");
		numeric ++;
		
		
		
	}
	 
	
	public static List<TaxiTicket> createtaxi(int n)
	{
		List<TaxiTicket> taxies =new ArrayList<>();
		
		for(int i=0;i<n;i++)
		{
			 taxies.add(new TaxiTicket()) ;
		}
		return taxies;
	}
	public static List<TaxiTicket> freeTaxis(List<TaxiTicket> taxis,int pickup_time,int pickup_point)
	{
		List<TaxiTicket> freetaxis =new ArrayList<>();
		for(TaxiTicket t:taxis)
		if(t.freeTime <= pickup_time &&Math.abs(pickup_point-t.currentSpot)<=(pickup_time-t.freeTime))
		{
			freetaxis.add(t);
		}
		return  freetaxis;
		
	}
	
	
	public static void cancel(String searchId,List<TaxiTicket> taxis)
	{
		boolean val =true;
		outer :
		for(TaxiTicket T :taxis)
		{
			int n =T.trips.size();
			
			for(int i=0;i<n;i++)
			{
			String searchString=T.trips.get(i);
			if(searchString.startsWith(searchId))
			{
				String [] tokens = searchString.split(" ");
				int a =tokens.length;
				if(tokens[a-1].contentEquals("cancel"))
				{
					System.out.println("Already Cancelled");
					val = false;
					break outer;
				}
				
				String newStr=searchString.concat(" cancel");
				System.out.println("Cancelled Fine:15 Rs");
				T.trips.remove(i);
				T.trips.add(i, newStr);
				//System.out.println(tokens[a-1]);
				int x =Integer.parseInt(tokens[a-1] );
				//System.out.println( T.totalEarning);
				T.totalEarning=((T.totalEarning )-x )+15;
				//System.out.println( T.totalEarning);
				val = false;
				
				break outer;
			}
			 
			
			
			}
			 
			//System.out.println(T);
		}
		if(val)
		{
			System.out.println("Booking Not Exist");
		}
	}
	
	
	 
	
	
}
 
 

public class BookingTicket extends Ticket
{
	public static void main(String[] args) 
	{
		List<TaxiTicket> taxis = createtaxi(4);
		int id=1;
		int customerChoice =0;
		int flag=1;
		int customerId =id;
		int pickupTime =0;
		int pickupPoint =0;
	    int dropPoint =0;
		HashMap<Integer,String> area = new HashMap<>();
		area.put(1,"Mettur");
		area.put(2,"Gv");
		area.put(3,"Kolathur");
		area.put(4,"Salem");
		boolean x = true;
		
		while(x)
		{
			
		flag=1;
		System.out.println("1- Book Ticket");
	    System.out.println("2- Taxi List");
	    System.out.println("3- Cancel");
	    System.out.println("4- Exit");
	    
	    
	    //System.out.println("4- Exit");
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
		    List<TaxiTicket> freetaxis=freeTaxis(taxis,pickupTime,pickupPoint);
		    if(freetaxis.size() == 0)
	        {
	            System.out.println("No Taxi can be alloted");
	            flag=0;
	            System.out.println("If You want to Book a Rapido");
	            System.out.println("1 - Yes \n2 - No ");
	            int rChoise = input.nextInt();
	            if(rChoise == 1)
	            {
	            	generateOtp(customerId,pickupPoint,dropPoint,pickupTime,area,"Rapido" );
	            }
	               
	        } 
		    if(flag==1)
		    {
		    Collections.sort(freetaxis, new Mysort());
		    bookticket(customerId,pickupPoint,dropPoint,pickupTime,freetaxis);
		    id++;
		    generateOtp(customerId,pickupPoint,dropPoint,pickupTime,area );
		    }
	        break;
		}
		case 2:
        {
            
             for(TaxiTicket t : taxis)
                t.printVehicleDetails();
             for(TaxiTicket t : taxis)
                t.printDetails();
            break;
        }
        
        
		case 3:
		{
			System.out.println("**Enter Customer id**");
			String searchId = input.next();
			cancel(searchId,taxis);
			
			
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




