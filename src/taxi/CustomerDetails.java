package taxi;

import java.util.List;
import java.util.Scanner;
public  class CustomerDetails {
	Scanner input = new Scanner(System.in);
	static int id=1;
	int customerId =id;
	String customerName ;
	int age;
	String phoneNo;
	int pickupTime ;
	int pickupPoint ;
    int dropPoint ;
    String bookingStatus;
	public void setDetails()
	{
		System.out.println("Enter Your Name");
		customerName = input.nextLine();
		System.out.println("Enter Your Age");
		age = input.nextInt();
		System.out.println("Enter Your PhoneNO");
		phoneNo= input.next();
	}
	public void setTripDetails()
	{
		 
		System.out.println("Enter the Pickup Point");
	    pickupPoint = input.nextInt();
	    System.out.println("Enter Drop point point");
	    dropPoint = input.nextInt();
	    while(pickupPoint >4 || pickupPoint <0)
	    {
	    	System.out.println("Enter a Valid PickUp Point");
	    	pickupPoint = input.nextInt();
	    	
	    }
	    while(dropPoint >4 || dropPoint <0||pickupPoint == dropPoint)
	    {
	    	System.out.println("Enter a Valid Drop point");
	    	dropPoint = input.nextInt();
	    }
	    System.out.println("Enter the Pickup time, Taxi is Only available between 6 - 24");
	    pickupTime = input.nextInt();
	    while(!(pickupTime >=6 && pickupTime<=24) )
	    {
	    	System.out.println("Enter a Valid Pickup Time");
	    	pickupTime = input.nextInt();
	    }	
	}
	public void getDetails(List<CustomerDetails> customerList)
	{
		for(CustomerDetails customer : customerList)
		{
			System.out.println(customer);
		}
	}
	@Override
	public String toString() {
		return  "customerName=" + customerName + ", age=" + age + ", phoneNo="
				+ phoneNo + "\npickupTime=" + pickupTime + ", pickupPoint=" + pickupPoint + ", dropPoint=" + dropPoint
				+ ", bookingStatus=" + bookingStatus ;
	}
 
	
}
