/*
 * Name: Yuki Waka
 * Date: June 22,2020 
 * Assignment4
 * Student#: 141082180
 * */
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Second {

	@SuppressWarnings("resource")
	public static void main(String args[]) {
		
		Student[] Students = new Student[3];
		List<Student> sections = new ArrayList <Student>();
		
		
		for(int i = 0; i < 3; i++) {
		
		Scanner sc= new Scanner(System.in);    
		System.out.println("Enter Student Id: ");  
		int id= sc.nextInt();  
		System.out.println("Enter first name:  ");  
		String f= sc.next(); 
		System.out.println("Enter last name: ");  
		String l= sc.next();  
		
		ArrayList<String> list = new ArrayList<String>();
	
		System.out.println("Please enter your course name: (Exit - 'N')");
		
		while(true){
		  
		    String answer = sc.next(); 
		    if (answer.equals("N")){
		        break; 
		    }
		    list.add(answer);
		}
		//set Student
		Students[i] = new Student();
		Students[i].setId(id);
		Students[i].setFirstName(f);
		Students[i].setLastName(l);
		Students[i].setCourse(list);
		sections.add(Students[i]);
		}
		
	
	   //store into file
		try {

			FileOutputStream fos = new FileOutputStream("file.out");

			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(sections);
	

			oos.flush();
			fos.close();
		
			for(int i = 0; i < 3; i++)
				System.out.println("Student Id: " + Students[i].getId()+ ", Name: " + Students[i].getFirstName()+" " + Students[i].getLastName()+", Course: " + Students[i].getCourse());
		
		} catch (Throwable e) {
			System.err.println(e);
		}
	}
}

