///////////////////////////////////////////////////////////////////////////////
// 
// Main Class File:  AsTheCrowFlies
// File:             City.java
// Semester:         CS302 Spring 2015
//
// Author:           Matthew Quinn
// Email:            msquinn2@wisc.edu
// CS Login:         mquinn
// Lecturer's Name:  Debra Deppler
// Lab Section:      325
//
// Pair Partner:     Kyle Hagemann
// Email:            kfhagemann@wisc.edu
// CS Login:         hagemann
// Lecturer's Name:  Debra Deppler
// Lab Section:      324
//
///////////////////////////////////////////////////////////////////////////////

/**
 * Creates a city with a name, a state,
 *  a latitude,and a longitude.
 * <p>Bugs: no bugs
 *
 * @author Matt Quinn
 */
public class City {
	private	String state;//name of state
	private String name;//name of city
	private double latitude;//latitude of city
	private double longitude;//longitude of city


	/**
	 * Constructs a city object
	 * @param state Name of state.
	 * @param name Name of city.
	 * @param latitude Latitude coordinate.
	 * @param longitude Longitude coordinate.
	 */
	public City(String state, String name, double latitude, double longitude ){
		this.state = state.toUpperCase();
		this.name = name.toUpperCase();
		this.latitude = latitude;
		this.longitude = longitude;
	}
	/**
	 * Returns state name
	 * @return Name of state.
	 */
	public String getState(){
		return this.state;
	}
	/**
	 * Returns city name
	 * @return Name of city.
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * Returns latitude coordinate
	 * @return Latitude coordinate.
	 */
	public double getLatitude(){
		return this.latitude;
	}
	/**
	 * Returns longitude coordinate
	 * @return Longitude coordinate.
	 */
	public double getLongitude(){
		return this.longitude;
	}

	/**
	 * Prints info about city 
	 * @Overide toString
	 * @return To string for city object.
	 */
	@Override
	public String toString(){
		return state + ","+ name + ","+
				latitude + ","+ longitude;
	}
}
