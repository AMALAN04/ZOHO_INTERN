package taxi;

import java.util.HashMap;

public interface Notification {
	public  void generateOtp( CustomerDetails customer,HashMap<Integer,String> area);
}
