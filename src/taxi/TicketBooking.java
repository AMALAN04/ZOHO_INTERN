package taxi;
import java.util.HashMap;
import java.util.List;
public interface TicketBooking 
{
	public boolean  bookticket( HashMap<Integer,String> areas,List<Taxi> taxis,CustomerDetails customer);
	public  void cancel(String searchId,List<Taxi> taxis,List<CustomerDetails> customerList);
}
