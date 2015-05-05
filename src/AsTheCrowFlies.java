import java.util.*;
import java.io.*;
public class AsTheCrowFlies {
	private static ArrayList <City> availableCities = new ArrayList<City>();
	private static Scanner scnr = new Scanner(System.in);

	//Main Method
	public static void main(String[] args){
		menu();
	}




	private static void optionOne() {
		System.out.println("Enter the filename:");

		String fileName = scnr.nextLine();
		File file = new File(fileName);
		Scanner in = null;
		try{
			in = new Scanner(file);
			in.useDelimiter(",");
		}catch(FileNotFoundException e){
			System.out.println("Enter Valid File Name");
			return;
		}
		
		int count = 0;
		while(in.hasNext()){
			String state = in.next();
			String cityName = in.next();
			Double latitude = in.nextDouble();
			Double longitude = in.nextDouble();
			City city = new City (state,cityName,latitude,longitude);
			availableCities.add(city);
			count++;
		}
		System.out.println(count+" cities added");
	}

	private static void menu() {
		int results = -1;
		do{
			System.out.println("1. Load available cities from a file"+"\n"+
					"2. Display available cities"+"\n"+
					"3. Create a trip"+"\n"+
					"4. Add a city to available cities"+"\n"+
					"5. Exit Program"+"\n"+
					"Enter choice as integer [1-5]:");
			String input = scnr.nextLine();
			results = -1;
			switch(input){
			case "1":
				results = 1;
				optionOne();
				break;
			case"2":
				results = 2;
				System.out.println("2");
				break;
			case"3":
				results = 3;
				System.out.println("3");
				break;
			case"4":
				results = 4;
				System.out.println("4");
				break;
			case"5":
				results = 5;
				System.out.println("5");
				break;
			default:
				System.out.println("'" + input + "'" + " " + "is not a valid "
						+ "choice.");
				break;
			}
		} while(results != 5);
	}
}
