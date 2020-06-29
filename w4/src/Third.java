/*
 * Name: Yuki Waka
 * Date: June 22,2020 
 * Assignment4
 * Student#: 141082180
 * */
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Third {

	@SuppressWarnings("unchecked")
	public static void main(String args[]) {
		
		List<Student> studentObj = new ArrayList <Student>();
		
		//Student studentObj = null;

		try {

			FileInputStream fis = new FileInputStream("file.out");

			ObjectInputStream ois = new ObjectInputStream(fis);
	
			studentObj = (List<Student>)ois.readObject();

			fis.close();

		} catch (Throwable e) {
			System.err.println(e);
		}
		 
		for (int i = 0; i < studentObj.size(); i++)
		System.out.println("Student Id: " + studentObj.get(i).getId()+ ", Name: " + studentObj.get(i).getFirstName()+" " + studentObj.get(i).getLastName()+", Course: " + studentObj.get(i).getCourse());
	
	}
}
