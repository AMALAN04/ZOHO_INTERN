package taxi;

import java.util.HashMap;

public class SmsNotification implements Notification {
	static int series;
	public  void generateOtp(CustomerDetails customer,HashMap<Integer,String> area){
		int amount = ((Math.abs((customer.dropPoint) - (customer.pickupPoint)) * 15)-5)*10+100;
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("**ENJOY YOUR TAXI RIDE**" );
		System.out.println("BOOKING Id   : " + customer.customerId );
		System.out.println("Pickup Point : " + area.get(customer.pickupPoint) );
		System.out.println("Drop Point   : " + area.get(customer.dropPoint) );
		System.out.println("Pickup Time  : " + customer.pickupTime );
		String OTP =""+customer.customerId%10 +customer.pickupPoint+customer.dropPoint+(series+customer.customerId)%10;
		System.out.println("OTP          : " + OTP );
		System.out.println("Cost         : " + amount+" Rs" );
		System.out.println("------------------------------------------------------------------------------------");
	    series++;
	}

}
