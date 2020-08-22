/*
 * Name: Yuki Waka
 * Date: August 10,2020
 * 
 * */
import java.io.*;

public class Car implements Serializable {

	private String model;
	private String colour;
	private double mileage;
	private String registration;
	
	public Car() throws java.rmi.RemoteException {
		
		    super();
	}

	public Car( String brand, String name, double m )throws java.rmi.RemoteException {
		model = brand;
		colour = name;
		mileage = m;
		registration = "unregistered";
	}
	public void setPlate(String plate) {
		registration = plate;
	}

	public String toString() {
		return "Model: " + model + " Colour: " + colour + 
				" mileage: " +  mileage + 
				" Plate: " + registration;
	}

	public void getRegistered(String plate) {
		registration = plate;
	}
}