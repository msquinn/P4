public class testing_file{
	public static void main(String[] args){
		City c1 = new City("WI", "Madison", 43.074722, -89.384444);
		City c2 = new City("WI", "Milwaukee", 43.038902, -87.906471);
		City c3 = new City("Illinois","Chicago",41.881832,-87.623177);
		
		Trip trip = new Trip();
		trip.addCity(c1);
		trip.addCity(c2);
		trip.addCity(c3);
		
		System.out.println(trip);
	}
}