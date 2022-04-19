package taxi;

import java.util.List;
import java.util.Scanner;
public  class CustomerDetails {
	Scanner input = new Scanner(System.in);
	String customerName ;
	int age;
	String phoneNo;
	String trips;
	void setDetails()
	{
		System.out.println("Enter Your Name");
		customerName = input.nextLine();
		System.out.println("Enter Your Age");
		age = input.nextInt();
		System.out.println("Enter Your PhoneNO");
		phoneNo= input.next();
	}
	public void setTrip(String trip)
	{
		this.trips = trip;
	}
	@Override
	public String toString() {
		return "Name : " + customerName + ", Age : " + age + ", Phone No : "
				+ phoneNo +" \nTrip=" + trips + "\n";
	}
	public void getDetails(List<CustomerDetails> customerList)
	{
		for(CustomerDetails customer : customerList)
		{
			System.out.println(customer);
		}
	}
	
}
