package taxi;
import java.util.HashMap;
import java.util.List;
public class TaxiTicketBooking extends AvailableTaxi implements TicketBooking
{
	static int series;
	public boolean bookticket(int customerId, int pickupPoint, int dropPoint, int pickupTime,
		 HashMap<Integer, String> areas, List<Taxi> taxis,CustomerDetails customer)  {
		 List<Taxi> freeTaxis=freeTaxis(taxis,pickupTime,pickupPoint);
		 if (freeTaxis != null) { 
			 int min=Integer.MAX_VALUE;
			 Taxi bookedTaxi=null;
			 int newFreeTime=6;
			 int currentSpot=0;
			 int earning=0;
			 int dropTime=0;
			 String tripDetails="";
			 int distanceBetweenpickUpandDrop = 0;
		 
			 for(Taxi t : freeTaxis) {
		         int distanceBetweenCustomerAndTaxi = Math.abs(t.getCurrentSpot() - pickupPoint ) * 15;
		         if(distanceBetweenCustomerAndTaxi < min)  {                           //free taxi at the nearest point is booked
		         
		             bookedTaxi = t;
		             distanceBetweenpickUpandDrop = Math.abs((dropPoint) - (pickupPoint)) * 15;
		             earning = (distanceBetweenpickUpandDrop-5) * 10 + 100;
		             dropTime  = pickupTime + distanceBetweenpickUpandDrop/15;
		             newFreeTime = dropTime;
		             currentSpot = dropPoint;
		             tripDetails = customerId + "               " + customerId + "          " + pickupPoint +  "      " + dropPoint + "       " + pickupTime + "          " +dropTime + "           " + earning;
		             min = distanceBetweenCustomerAndTaxi;
		         }
			 
			 }
			 customer.trips= " Booking Id : " +customerId + ", Taxi Id : "+bookedTaxi.getId()+ ", Pickup Point : " + pickupPoint +  ", Drop Point : " + dropPoint + ", Pickup Time : " + pickupTime + ", Drop Time : " +dropTime + ", Earning : " +earning;
			 bookedTaxi.setDetails(true, currentSpot,  newFreeTime,bookedTaxi.getTotalEarning() + earning,tripDetails);
			 System.out.println("Taxi " + bookedTaxi.getId() + " booked");
			 generateOtp(customerId,pickupPoint,dropPoint,pickupTime,areas );
			 return true;
		 }	 
		 return false;
	}
	
	public  void cancel(String searchId,List<Taxi> taxis,List<CustomerDetails> customerList)
	{
		boolean val =true;
		outer :
		for(Taxi T :taxis) {
				int n =T.getTrips().size();
				for(int i=0;i<n;i++) {
					String searchString=T.getTrips().get(i);
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
						if(i==0)
						{
							T.setCurrentSpot(1);
							T.setFreeTime(6);
						}
						else{
				
							String [] priorTokens = T.getTrips().get(i-1) .split(" ");
							T.setCurrentSpot(Integer.parseInt(priorTokens[31]));
							T.setFreeTime(Integer.parseInt(priorTokens[48]));	
						}
						for(CustomerDetails individualCustomer : customerList)
			    		{
			    			 if(individualCustomer.trips.startsWith(" Booking Id : " +searchId)) {
			    				 String cancelTrip = individualCustomer.trips.concat("Cancel");
			    				 individualCustomer.trips= cancelTrip;
			    			 }
			    				 
			    		}
						String newStr=searchString.concat(" cancel");
						System.out.println("Cancelled Fine:15 Rs");
						T.removeTrips(i); 
						T.addTrips(i, newStr);
						int x =Integer.parseInt(tokens[a-1] );
						T.setTotalEarning(((T.getTotalEarning() )-x )+15);
						val = false;
						break outer;
					}
				
				}
				 
			}
			if(val)
			{
				System.out.println("Booking Not Exist");
			}
	}
	public  void generateOtp(int customerId,int pickupPoint,int dropPoint,int pickupTime,HashMap<Integer,String> area){
		int amount = ((Math.abs((dropPoint) - (pickupPoint)) * 15)-5)*10+100;
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("**ENJOY YOUR TAXI RIDE**" );
		System.out.println("BOOKING Id   : " + customerId );
		System.out.println("Pickup Point : " + area.get(pickupPoint) );
		System.out.println("Drop Point   : " + area.get(dropPoint) );
		System.out.println("Pickup Time  : " + pickupTime );
		String OTP =""+customerId%10 +pickupPoint+dropPoint+(series+customerId)%10;
		System.out.println("OTP          : " + OTP );
		System.out.println("Cost         : " + amount+" Rs" );
		System.out.println("------------------------------------------------------------------------------------");
	    series++;
	}

	 
	

}
