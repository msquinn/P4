import java.util.ArrayList;
import java.util.*;
import java.io.*;
public class AsTheCrowFlies {
private static	ArrayList <City> availableCities = new ArrayList();
	
	
	
	
	
//Main Method
	public static void main(String[]args){
Scanner scnr = new Scanner(System.in);
boolean runProgram = true;
do {
	System.out.println("1. Load available cities from a file"+"\n"+
			  "2. Display available cities"+"\n"+
			  "3. Create a trip"+"\n"+
			   "4. Add a city to available cities"+"\n"+
			   "5. Exit Program"+"\n"+
			   "Enter choice as integer [1-5]: 1");
	int input  = scnr.nextInt();
	
	if (input == 5){
		runProgram = false;
	}
	if(input > 5|| input < 1){
		System.out.println("Please Enter a valid option number");
	}
	if(input == 2){
		for(int i =0; i<availableCities.size();i++){
			System.out.println(availableCities.get(i));
		}
	}
}while (runProgram == true);
}
}
