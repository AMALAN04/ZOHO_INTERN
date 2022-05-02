package taxi;
import java.util.HashMap;
import java.util.List;
public class TaxiTicketBooking implements TicketBooking
{
	public boolean bookticket(HashMap<Integer, String> areas, List<Taxi> taxis,CustomerDetails customer)  {
		 AvailableTaxi availableTaxi = new AvailableTaxi();
		 List<Taxi> freeTaxis=availableTaxi.freeTaxis(taxis,customer.pickupTime,customer.pickupPoint);
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
		         int distanceBetweenCustomerAndTaxi = Math.abs(t.getCurrentSpot() - customer.pickupPoint ) * 15;
		         if(distanceBetweenCustomerAndTaxi < min)  {                           //free taxi at the nearest point is booked
		         
		             bookedTaxi = t;
		             distanceBetweenpickUpandDrop = Math.abs((customer.dropPoint) - (customer.pickupPoint)) * 15;
		             earning = (distanceBetweenpickUpandDrop-5) * 10 + 100;
		             dropTime  = customer.pickupTime + distanceBetweenpickUpandDrop/15;
		             newFreeTime = dropTime;
		             currentSpot = customer.dropPoint;
		             tripDetails = customer.customerId + "               " + customer.customerId + "          " + customer.pickupPoint +  "      " + customer.dropPoint + "       " + customer.pickupTime + "          " +dropTime + "           " + earning;
		             min = distanceBetweenCustomerAndTaxi;
		         }
			 
			 }
			 bookedTaxi.setDetails(true, currentSpot,  newFreeTime,bookedTaxi.getTotalEarning() + earning,tripDetails);
			 customer.bookingStatus= "Booked";
			 System.out.println("Taxi " + bookedTaxi.getId() + " booked");
			 Notification notification = new SmsNotification ();
			 notification.generateOtp(customer ,areas );
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
			    			 if(individualCustomer.customerId== Integer.parseInt(searchId))
			    			 {
			    				 System.out.println("llll");
			    				 individualCustomer.bookingStatus="Cancelled";
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


	 
	

}
