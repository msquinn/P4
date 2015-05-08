///////////////////////////////////////////////////////////////////////////////
// 
// Main Class File:  AsTheCrowFlies
// File:             Trip.java
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

import java.util.ArrayList;

/**
 * Trip class creates and maintains data of a trip.
 * A trip is made up of cities and there distances.
 *
 * <p>Bugs: no bugs
 *
 * @author Kyle Hagemann
 */
public class Trip {
	/* Trip list */
	private ArrayList<City> cities = null;

	/**
	 * Trip constructor
	 * @param cities A list of cities in order of visiting.
	 */
	public Trip(ArrayList<City> cities){
		this.cities = new ArrayList<City>();
		this.cities.addAll(cities);
	}

	/**
	 * Trip overload constructor
	 */
	public Trip(){
		this.cities = new ArrayList<City>();
	}

	/**
	 * Get size of trip.
	 * @return Size of trip
	 */
	public int size(){
		return this.cities.size();
	}

	/**
	 * Adds city to trip.
	 * @param City City to add.
	 */
	public void addCity(City city){
		this.cities.add(city);
	}

	/**
	 * Empties cities from trip.
	 */
	public void empty(){
		this.cities.removeAll(cities);
	}

	/**
	 * Returns distance between two cities in meters.
	 * Uses the Haversine formula to compute the distances.
	 * @param c1 City one
	 * @param c2 City two
	 * @return Distance between two cities.
	 */
	public int getDistance(City c1, City c2){
		final int R = 6371; // Earth's radius

		double c1Lat = c1.getLatitude(); // city one latitude
		double c1Long = c1.getLongitude(); // city one longitude
		double c2Lat = c2.getLatitude(); // city two latitude
		double c2Long = c2.getLongitude(); // city two longitude

		double deltaLat = Math.toRadians(c2Lat-c1Lat);//distance between lats
		double deltaLong = Math.toRadians(c2Long-c1Long);//distance between logs

		double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2) +
				Math.cos(Math.toRadians(c1Lat)) * Math.cos(Math.toRadians(c2Lat)
						) *
						Math.sin(deltaLong / 2) * Math.sin(deltaLong / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		double distance = R * c;
		distance *= 1000;
		return (int)distance;
	}
	
	/**
	 * Converts meters to miles.
	 * @param meters Distance in meters.
	 * @return Distance in miles.
	 */
	public int metersToMile(int meters){
		final double m = 6.2 / 10000; //one meter
		return (int)(meters * m);
	}

	/**
	 * Prints the amount of cities in the trip as well as their distances.
	 * @return To string of trip.
	 */
	@Override
	public String toString(){
		String s = ""; // string to return
		int totalDistance = 0; // total distance of trip

		s += "There are " + this.cities.size() + " cities in this trip.\n";

		//Goes through the cities array to output two cities and distances.
		for(int i=0; i<this.cities.size()-1; i++){
			s += cities.get(i).getName().toUpperCase() + " to ";
			s += cities.get(i+1).getName().toUpperCase() +
					" as the crow flies is about ";
			int distance = getDistance(this.cities.get(i),
					this.cities.get(i+1));
			totalDistance += distance;
			s += distance + " meters (~" + metersToMile(distance) + " miles)\n";
		}

		//outputs last city to first city and distance
		s += cities.get(this.cities.size()-1).getName().toUpperCase() + " to ";
		s += cities.get(0).getName().toUpperCase() + 
				" as the crow flies is about ";
		int distance = getDistance(this.cities.get(this.cities.size()-1),
				this.cities.get(0));
		totalDistance += distance;
		s += distance + " meters (~" + metersToMile(distance) + " miles)\n";

		//Calculates the total distances of the trip and returns it in miles.
		s += "Total Distance: " + totalDistance + " meters (~" + 
				metersToMile(totalDistance) + " miles)";
		return s;
	}
}
