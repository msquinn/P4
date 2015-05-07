import java.util.ArrayList;


public class Trip {
	/* Trip list */
	private ArrayList<City> cities = null;

	/**
	 * Cities constructor
	 * @param cities A list of cities in order of visiting.
	 */
	public Trip(ArrayList<City> cities){
		this.cities = new ArrayList<City>();
		this.cities.addAll(cities);
	}

	/**
	 * Cities constructor
	 */
	public Trip(){
		this.cities = new ArrayList<City>();
	}
	
	/**
	 * Get size of trip
	 * @return int Size of trip
	 */
	public int size(){
		return this.cities.size();
	}

	/**
	 * Adds city to list.
	 * @param City City to add.
	 */
	public void addCity(City city){
		this.cities.add(city);
	}
	
	/**
	 * Empties cities.
	 */
	public void empty(){
		this.cities.removeAll(cities);
	}

	/**
	 * Returns distance between two cities in meters.
	 * @param c1 City one
	 * @param c2 City two
	 */
	public int getDistance(City c1, City c2){
		final int R = 6371; // Earth's radius

		double c1Lat = c1.getLatitude();
		double c1Long = c1.getLongitude();
		double c2Lat = c2.getLatitude();
		double c2Long = c2.getLongitude();

		double deltaLat = Math.toRadians(c2Lat-c1Lat);
		double deltaLong = Math.toRadians(c2Long-c1Long);

		double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2) +
				Math.cos(Math.toRadians(c1Lat)) * Math.cos(Math.toRadians(c2Lat)) *
				Math.sin(deltaLong / 2) * Math.sin(deltaLong / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		double distance = R * c;
		distance *= 1000;
		return (int)distance;
	}

	public int metersToMile(int meters){
		final double m = 6.2 / 10000; //one meter
		return (int)(meters * m);
	}

	@Override
	public String toString(){
		String s = "";
		int totalDistance = 0;

		s += "There are " + this.cities.size() + " cities in this trip.\n";

		for(int i=0; i<this.cities.size()-1; i++){
			s += cities.get(i).getName().toUpperCase() + " to ";
			s += cities.get(i+1).getName().toUpperCase() + " as the crow flies is about ";
			int distance = getDistance(this.cities.get(i), this.cities.get(i+1));
			totalDistance += distance;
			s += distance + " meters (~" + metersToMile(distance) + " miles)\n";
		}

		s += cities.get(this.cities.size()-1).getName().toUpperCase() + " to ";
		s += cities.get(0).getName().toUpperCase() + " as the crow flies is about ";
		int distance = getDistance(this.cities.get(this.cities.size()-1), this.cities.get(0));
		totalDistance += distance;
		s += distance + " meters (~" + metersToMile(distance) + " miles)\n";

		s += "Total Distance: " + totalDistance + " meters (~" + metersToMile(totalDistance) + " miles)";
		return s;
	}
}
