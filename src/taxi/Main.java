/************************************************************************************************************************************
-There are 4 taxi’s.
-The are 4 points(“Mettur”, “ Gv”, “Kolathur” ,“Salem”).
-All the points are in a straight line, and each point is 15kms away from the adjacent points.
-It takes 60 mins to travel from one point to another
-Each taxi charges Rs.100 minimum for the first 5 kilometers and Rs.10 for the subsequent
kilometers.
-For simplicity, time can be entered as absolute time.
-All taxi’s are initially stationed at “Mettur” and available from 6Am.
-When a customer books a Taxi, a free taxi at that point is allocated
-If no free taxi is available at that point, a free taxi at the nearest point is allocated.
-If two taxi’s are free at the same point, one with lower earning is allocated.
- If the customer wanted to cancel the ticket, Rs 15 is charged as a fine.

No.of.Class - 7

class Area -> Used to create new areas

Class Taxi ->  Holds taxi details extends Vehicle class;

class AvailabeTaxi ->  Create new taxis and add them to a linked list. Divide available taxis into categories and add them to the new list.

class TaxiTicketBooking -> Ticket Booking and Cancelling.

Class MySort -> Sort available taxis based their total earning.

abstract class Vehicle -> Holds details related to vehicles.

No.of.interface - 2

interface TicketBooking

interface GenerateOTP

****************************************************************************************************************************************/
package taxi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		List<Taxi> taxis = CreateTaxi.createtaxi(4); // Create new taxi list(static function called through class name)
		List<CustomerDetails> customerList = new ArrayList<>();
		int id = 1;
		int customerChoice = 0;
		boolean bookedStatus;
		Area area = new Area();
		HashMap<Integer, String> areas = area.createArea();// Area are created
		boolean x = true;
		while (x) {
			char back;
			TicketBooking trip = new TaxiTicketBooking();//Abstraction Using interface
			System.out.println("1- Book Ticket");
			System.out.println("2- Taxi List");
			System.out.println("3- Cancel");
			System.out.println("4- Customer Details");
			System.out.println("5- Exit");
			Scanner input = new Scanner(System.in);
			customerChoice = input.nextInt();
			try {
				switch (customerChoice) {
				case 1:
					CustomerDetails customer = new CustomerDetails(); //new customers
					customer.setDetails();
					area.showArea();
					customer.setTripDetails();
					System.out.println("Want to go back? Enter \"b\".\nTo proceed press any Key..! ");
					back = input.next().charAt(0);
					if ((back == 'b') || back == 'B') {
						break;
					}
					bookedStatus = trip.bookticket(areas, taxis, customer);// Check for available taxis & book ticket
					if (bookedStatus) {
						customer.id++;
						customerList.add(customer); // add Booked customer details to arraylist
					}
					break;
				case 2:
					VehicleDetailsPrinter printer = new TaxiDetailsPrinter();//Abstraction
					for (Taxi t : taxis)
						printer.printVehicleDetails(t);// Print only vehicle details
					for (Taxi t : taxis)
						printer.printDetails(t);// Print vehicle details along with trip
					break;
				case 3:
					System.out.println("**Enter Booking Id**");
					String searchId = input.next();
					System.out.println("Want to go back? Enter 'b' \nTo proceed press any Key..! ");
					back = input.next().charAt(0);
					if ((back == 'b') || back == 'B') {
						break;
					}
					trip.cancel(searchId, taxis, customerList);
					break;
				case 4:
					System.out.println("Customer Details");
					for (CustomerDetails individualCustomer : customerList) {
						System.out.println(individualCustomer + "\n");
					}
					break;
				case 5:
					System.out.println("**Thank You**");
					return;
				default:
					System.out.println("Choose a valid key");
				}
			} catch (Exception e) {
				System.out.println("Enter Valid Details");
			}
		}
	}
}
