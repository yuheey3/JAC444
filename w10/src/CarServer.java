/*
 * Name: Yuki Waka
 * Date: August 10,2020
 * 
 * */
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.Naming;

public class CarServer {
	
	public CarServer() {
		try {
			
			CarInterface c = new CarImplementation();
			
			//Naming.rebind("rmi://localhost:4099/CarRegistration", c);
			Registry registry = LocateRegistry.createRegistry(6099);
			registry.rebind("CalculatePlate", c);
			
			System.out.println("this server is going to register the cars");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void main(String[] args) {
		new CarServer();
		System.out.println("CalculatePlate is running");
	}
}