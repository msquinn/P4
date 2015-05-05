import java.util.*;
import java.io.*;

public class AsTheCrowFlies {
	private static ArrayList <City> availableCities = new ArrayList<City>();
	private static Scanner scnr = new Scanner(System.in);

	//Main Method
	public static void main(String[] args){
		System.out.println("As The Crow Flies");
		System.out.println();
		menu();
	}

	/**
	 * Main menu option one.
	 */
	private static void optionOne() {
		System.out.print("Enter the filename: ");

		String fileName = scnr.nextLine();
		File file = new File(fileName);
		Scanner in = null;
		try{
			in = new Scanner(file);
			in.useDelimiter(",");
		}catch(FileNotFoundException e){
			System.out.print("Enter Valid File Name: ");
			return;
		}

		int count = 0;
		while(in.hasNextLine()){
			String[] temp = in.nextLine().split(",");
			String state = temp[0];
			String cityName = temp[1];
			Double latitude = new Double(temp[2]);
			Double longitude = new Double(temp[3]);

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
	 */
	public static void optionTwo(){
		for(int i=0; i<availableCities.size(); i++){
			System.out.println(availableCities.get(i));
		}
		System.out.println();
		return;
	}

	/**
	 * Main menu option three.
	 */
	public static void optionThree(){
		//TODO
		return;
	}

	/**
	 * Main menu option four.
	 */
	public static void optionFour(){
		System.out.print("Enter state name: ");
		String state = scnr.nextLine().toUpperCase();

		System.out.print("Enter city name: ");
		String cityName = scnr.nextLine().toUpperCase();

		System.out.print("Enter latitude as double (-90.0 to 90.0): ");
		double lat = scnr.nextDouble();

		System.out.print("Enter longitude as double (-180.0 to 180.0): ");
		double longi = scnr.nextDouble();

		City city = new City(state, cityName, lat, longi);
		availableCities.add(city);
		System.out.println("Added: " + city);
		System.out.println();
		return;
	}

	/**
	 * Main menu option five.
	 */
	public static void optionFive(){
		System.out.println("Thank you for your business.");
		System.out.print("Saved available cities to available_cities.txt");

		PrintWriter writer = null;
		try{
			writer = new PrintWriter("available_cities.txt");
		} catch(FileNotFoundException e) {
			System.out.println("Print writer error");
			return;
		}
		
		for(int i=0; i<availableCities.size(); i++){
			writer.println(availableCities.get(i));
		}
		
		writer.close();
		return;
	}

	private static void menu() {
		int results = -1;
		do{
			System.out.print("1. Load available cities from a file"+"\n"+
					"2. Display available cities"+"\n"+
					"3. Create a trip"+"\n"+
					"4. Add a city to available cities"+"\n"+
					"5. Exit Program"+"\n"+
					"Enter choice as integer [1-5]: ");
			String input = scnr.nextLine();
			results = -1;
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
				optionThree();
				break;
			case"4":
				results = 4;
				optionFour();
				break;
			case"5":
				results = 5;
				optionFive();
				break;
			default:
				System.out.println("'" + input + "'" + " " + "is not a valid "
						+ "choice.");
				break;
			}
		} while(results != 5);
	}
}
