
public class City {
//instance variable
private	String state;
private String name;
private double latitude;
private double longitude;
	
	
	//constructor
	public City(String state, String name, double latitude, double longitude ){
	this.state = state;
	this.name = name;
	this.latitude = latitude;
	this.longitude = longitude;
}
	@Override 
	public String toString(){
		return state.toUpperCase() + ", "+ name.toUpperCase() + ", "+
	latitude + ", "+ longitude;
		
	}
	
	
	
	
	
}
