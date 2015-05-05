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
		try{
			int count = 0;
			scnr = new Scanner(file);
			while(scnr.hasNextLine()){
				scnr.useDelimiter(",");
				String state = scnr.next();
				String city = scnr.next();
				Double latitude = scnr.nextDouble();
				Double longitude = scnr.nextDouble();
				City city1 = new City (state,city,latitude,longitude);
				availableCities.add(city1);
				count++;
			}
			System.out.println(count+" cities added");
		}catch(FileNotFoundException e){
			System.out.println("Enter Valid File Name");
		}

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
				System.out.println("1");
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
