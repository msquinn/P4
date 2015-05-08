///////////////////////////////////////////////////////////////////////////////
//             
// Title:            AsTheCrowFlies
// Files:            AsTheCrowFlies.java , City.java , Trip.java
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

import java.util.*;
import java.io.*;

/**
 * Main class for program. Takes user input, calls to City class and Trip class,
 * displays main menu, and reads and writes to files. 
 * 
 * <p>Bugs: no bugs
 *
 * @author Kyle Hagemann , Matt Quinn
 */
public class AsTheCrowFlies {
	/*An arrayList of available cities*/
	private static ArrayList<City> availableCities = new ArrayList<City>();
	/*A scanner connected to the keyboard*/
	private static Scanner scnr = new Scanner(System.in);

	/**
	 * Main Method displays print statement. Calls menu();
	 * */
	public static void main(String[] args){
		System.out.println("As The Crow Flies");
		System.out.println();
		menu();
	}

	/**
	 * Main menu option one.
	 * User imports file, method reads file for a city, adds cities to 
	 * available cities.
	 */
	private static void optionOne() {
		System.out.print("Enter the filename: ");

		String fileName = scnr.nextLine();
		File file = new File(fileName);//creates new file
		Scanner in = null;
		try{
			in = new Scanner(file);//scans file. Ignores "," in file.
			in.useDelimiter(",");
		}catch(FileNotFoundException e){//catches exception, so it won't crash
			System.out.println("Unable to read file");
			System.out.println("0 cities added");
			System.out.println();
			return;
		}

		int count = 0;//counts amount of cities added
		while(in.hasNextLine()){
			/**
			 * Splits line into String array
			 * Separates Strings by "," 
			 * */
			String[] temp = in.nextLine().split(",");
			String state = temp[0];	//the state is located first			
			String cityName = temp[1];//city located second
			Double latitude = new Double(temp[2]);//latitude located third
			Double longitude = new Double(temp[3]);//longitude fourth
			/**creates new city*/
			City city = new City (state,cityName,latitude,longitude);
			availableCities.add(city);
			count++;
		}
		System.out.println(count+" cities added");
		System.out.println();
		in.close();
		return;
	}

	/**
	 * Main menu option two.
	 * Displays available cities
	 */
	public static void optionTwo(){
		//loops through availableCities arrayList and prints each city in it.
		for(int i=0; i<availableCities.size(); i++){
			System.out.println(availableCities.get(i));
		}
		System.out.println();
		return;
	}

	/**
	 * Main menu option three.
	 * @param currTrip Current trip object.
	 * @return Updated currTrip
	 */
	public static Trip optionThree(Trip currTrip){
		//Prints how many cities in availableCities
		System.out.println("There are " + availableCities.size() +
				" cities to choose from.");

		//Base case less than 2 cities to chooses from
		if(availableCities.size() < 2){
			System.out.println("Must have at least 2 cities to choose from.");
			System.out.println();
			return currTrip;
		}
		//asks if they want to add to their current trip
		if(currTrip.size() > 0){
			System.out.print("Add to current trip (y/n)? ");
			String input = scnr.nextLine();
			if(input.equals("y")){
				//empties currTrip
			} else if(input.equals("n")){
				currTrip.empty();
			}
		}

		if(currTrip.size() < 1){
			System.out.println("New trip created, needs at least two cities.");
		}
		int i = 0;//used to compare with availableCities.size()
		boolean run = true;//used to run while loop
		while(i<availableCities.size() && run){
			System.out.print("Enter next city name (or enter to end): ");
			String cityName = scnr.nextLine().toUpperCase();
			if(!cityName.equals("")){
				City temp = findCity(cityName);
				if(temp != null){
					currTrip.addCity(temp);//adds city to trip if it exists
				} 
			} else {
				run = false;//exits loop
			}
		}
		//checks size of currTrip
		if(currTrip.size()<2){
			System.out.println("Must have at least 2 cities in a trip."+ '\n');
			return currTrip;

		}
		System.out.println(currTrip);

		System.out.print("Write trip details to file (y/n)? ");
		String input = scnr.nextLine();
		if(input.equals("y")){
			PrintWriter writer = null;//sets writer to null
			//writes file
			try{
				System.out.print("Enter filename: ");
				String fileName = scnr.nextLine();
				writer = new PrintWriter(fileName);
			} catch(FileNotFoundException e) { //catches exception
				System.out.println("Print writer error");
				return currTrip;
			}
			writer.println(currTrip);

			writer.close();
		} else if(input.equals("n")){

		}
		return currTrip;
	}

	/**
	 * Find city by its name.
	 * @param name Name of city.
	 * @return City null if none found.
	 */
	private static City findCity(String name){
		for(int i=0; i<availableCities.size(); i++){
			if(availableCities.get(i).getName().equals(name)){
				return availableCities.get(i);
			}
		}
		return null;
	}

	/**
	 * Main menu option four.
	 * User adds cities to availableCities.
	 */
	public static void optionFour(){

		boolean latitude = false;//boolean used for first do-while loop
		boolean longitude = false;//boolean used for second do-while loop
		double lat = 91;//initializes latitude as invalid value
		double longi = 91;//initializes longitude as invalid value
		System.out.print("Enter state name: ");
		String state = scnr.nextLine().toUpperCase();//state name

		System.out.print("Enter city name: ");
		String cityName = scnr.nextLine().toUpperCase();//city name
		do{
			System.out.print("Enter latitude as double (-90.0 to 90.0): ");
			try	{
				lat = scnr.nextDouble();
				String next = scnr.nextLine();
				//checks to make sure there is nothing after the double
				if(next.length() != 0){
					System.out.println("Invalid input. Try again.");
					continue;//restarts loop
				}
				//checks validity of lat
				if(lat>=-90.0&&lat<=90.0){
					break;
				}
				if(lat<-90||lat>90){
					System.out.println("Invalid input. Try again.");
					latitude = true;
				}
			} catch(InputMismatchException e){    //catches exception
				System.out.println("Invalid input. Try again.");
				scnr.next();
			}
		}while(latitude = true);

		do{
			System.out.print("Enter longitude as double (-180.0 to 180.0): ");
			try{
				longi = scnr.nextDouble();
				String next = scnr.nextLine();
				//checks to make sure there is nothing after the double
				if(next.length() != 0){
					System.out.println("Invalid input. Try again.");
					continue;
				}
				//checks validity of longitude
				if(longi>=-180&&longi<=180){
					break;
				}
				if(longi<-180||longi>180){
					System.out.println("Invalid input. Try again.");
					longitude = true;
				}
			} 	catch(InputMismatchException e){ //catches exception
				System.out.println("Invalid input. Try again.");
				scnr.next();
			}
		}while(longitude = true);
		//creates new city. adds to availableCities
		City city = new City(state, cityName, lat, longi);
		availableCities.add(city);
		System.out.println("Added: " + city);
		System.out.println();
		return;
	}

	/**
	 * Main menu option five.
	 * Good-Bye message and saves available cities to available_cities.txt
	 * @param currTrip Current trip object.
	 */
	public static void optionFive(Trip currTrip){
		System.out.println("Thank you for your business.");
		//if there's no available cities, it exits
		if(availableCities.size() < 1){
			return;
		}
		System.out.print("Saved available cities to available_cities.txt");

		PrintWriter writer = null;
		//saves availableCities to available_cities.txt
		try{
			writer = new PrintWriter("available_cities.txt");
		} catch(FileNotFoundException e) { //catches exception
			System.out.println("Print writer error");
			return;
		}

		for(int i=0; i<availableCities.size(); i++){
			writer.println(availableCities.get(i));
		}

		writer.close();
		return;
	}
	
	/**
	 * Main menu display.
	 * Handles user input and validation. Calls on method they choose.
	 */
	private static void menu() {
		int results = -1; //Option choosen
		boolean show = true; //If main menu options should be printed
		Trip currTrip = new Trip(); //Current Trip object
		do{
			if(show){
				System.out.println("1. Load available cities from a file"+"\n"+
						"2. Display available cities"+"\n"+
						"3. Create a trip"+"\n"+
						"4. Add a city to available cities"+"\n"+
						"5. Exit Program");
			}
			show = true;
			System.out.print("Enter choice as integer [1-5]: ");
			String input = scnr.nextLine();
			results = -1;
			//checks user input and calls appropriate methods
			switch(input){
			case "1":
				results = 1;
				optionOne();
				break;
			case"2":
				results = 2;
				optionTwo();
				break;
			case"3":
				results = 3;
				currTrip = optionThree(currTrip);
				break;
			case"4":
				results = 4;
				optionFour();
				break;
			case"5":
				results = 5;
				optionFive(currTrip);
				break;
			default:
				System.out.println("Invalid input. Try again.");
				show = false;
				break;
			}
		} while(results != 5);//exits if they enter 5
	}
}
