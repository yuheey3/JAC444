/*
 * Name: Yuki Waka
 * Date: July 6,2020 
 * Assignment5
 * Student#: 141082180
 * */
import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {

	private int stdId;
	private String fName;
	private String lName;
	private ArrayList<String> courseList = new ArrayList<String>();

	// constructor
	public Student() {
		stdId = 0;
		fName = "";
		lName = "";
	}

	// setter
	public void setId(int id) {
		stdId = id;
	}

	public void setFirstName(String f) {
		fName = f;
	}

	public void setLastName(String l) {
		lName = l;
	}

	public void setCourse(ArrayList<String> list) {
		courseList = list;
	}

	// getter
	public int getId() {
		return stdId;
	}

	public String getFirstName() {
		return fName;
	}

	public String getLastName() {
		return lName;
	}

	public ArrayList<String> getCourse() {
		return courseList;
	}
}
