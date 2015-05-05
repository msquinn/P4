
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
	public String getState(){
		return this.state;
	}
	public void setState(String state){
		this.state = state;
	}
	
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
	public double getLatitude(){
		return this.latitude;
	}
	public void setLatitude(double latitude){
		this.latitude  = latitude;
	}
	public double getLongitude(){
		return this.longitude;
	}
	public void setLongitude(double longitude){
		this.longitude = longitude;
	}
	@Override 
	public String toString(){
		return state.toUpperCase() + ", "+ name.toUpperCase() + ", "+
	latitude + ", "+ longitude;
		
	}
	
	
	
	
	
}
