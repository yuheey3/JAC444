/*
 * Name: Yuki Waka
 * Date: August 10,2020
 * 
 * */
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/** This class implements the generation function */
public class CarImplementation extends UnicastRemoteObject implements CarInterface {
	
	public CarImplementation() throws RemoteException {
		super();
	}
	

	@Override
	public String registerCar(Car car) throws RemoteException {
		return car.hashCode()+ "";
	}
}