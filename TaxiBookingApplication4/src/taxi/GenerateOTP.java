package taxi;

import java.util.HashMap;

public interface GenerateOTP 
{
	 
	public void generateOtp(int customerId,int pickupPoint,int dropPoint,int pickupTime,HashMap<Integer,String> area);
}
 