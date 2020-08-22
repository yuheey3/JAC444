/*
 * Name: Yuki Waka
 * Date: August 10,2020
 * 
 * */
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class CarClient {
	
	
	public static void main(String[] args) {
		try {
			
			System.out.println("send this car to the server for registration");
			
			Car car = new Car("Toyata Corolla", "Dawn M", 1000);
			
			System.out.println(car.toString());
			
			CarInterface c = (CarInterface) Naming.lookup("rmi://localhost:6099/CalculatePlate");
			car.setPlate(c.registerCar(car));
			System.out.println("\nthe car returned by the server\n");
						
			System.out.println(car.toString());
			
		} catch (MalformedURLException murle) {
			System.out.println("MalformedURLException");
			System.out.println(murle);
		} catch (RemoteException re) {
			System.out.println("RemoteException");
			System.out.println(re);
		} catch (NotBoundException nbe) {
			System.out.println("NotBoundException");
			System.out.println(nbe);
		}
		System.out.println("the client is going to stop runing...");
	}
}