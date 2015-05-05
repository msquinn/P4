
public class Trip {
	/* Trip list */
	ArrayList<City> cities = null;
	
	/**
	 * Cities constructor
	 * @param cities A list of cities in order of visiting.
	 */
	public Trip(ArrayList<City> cities){
		this.cities = new ArrayList<City>;
		this.cities.addAll(cities);
	}
	
	/**
	 * Cities constructor
	 */
	public Trip(){
		this.cities = new ArrayList<City>;
	}
	
	/**
	 * Adds city to list.
	 * @param City City to add.
	 */
	public void addCity(City city){
		this.cities.add(city);
	}
	
	/**
	 * Returns distance between two cities.
	 * @param c1 City one
	 * @param c2 City two
	 */
	public int getDistance(City c1, City c2){
		
	}
	
	@Override
	public String toString(){
		String s = "";
		
	}
}
