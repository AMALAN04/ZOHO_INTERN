package taxi;

public class TaxiDetailsPrinter implements VehicleDetailsPrinter {
	public void printDetails(Taxi taxi) {
        System.out.println("Taxi - "+ taxi.getId() + " Total Earnings - " + taxi.getTotalEarning());
        System.out.println("TaxiID    BookingID    CustomerID    From    To    PickupTime    DropTime    Amount");
        for(String trip : taxi.getTrips())
        {
            System.out.println(taxi.getId() + "          " + trip);
        }
        System.out.println("--------------------------------------------------------------------------------------");
    }
	public void printVehicleDetails(Taxi taxi) {
        System.out.println("Taxi - "+ taxi.getId() + " Total Earnings - " + taxi.getTotalEarning() + " Current spot - " + taxi.getCurrentSpot() +" Free Time - " + taxi.getFreeTime());
        System.out.println("----------------------------------------------------------------------------------------");   
    }


}
