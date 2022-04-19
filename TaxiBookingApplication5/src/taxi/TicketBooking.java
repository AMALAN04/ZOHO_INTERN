package taxi;
import java.util.HashMap;
import java.util.List;
public interface TicketBooking 
{
	public boolean  bookticket(int customerId,int pickupPoint,int dropPoint,int pickupTime,HashMap<Integer,String> areas,List<Taxi> taxis,CustomerDetails customer);
	public  void cancel(String searchId,List<Taxi> taxis,List<CustomerDetails> customerList);
	//public void generateOtp(int customerId,int pickupPoint,int dropPoint,int pickupTime,HashMap<Integer,String> area);
}
