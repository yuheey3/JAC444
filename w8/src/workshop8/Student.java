/*
 * Name: Yuki Waka
 * Date: July 27,2020
 * 
 * */
package workshop8;

public class Student implements Comparable<Student> {

	private String firstName;
	private String lastName;
	private double grade;
	private String department;

    //constructor
	public Student(String fn, String ln, double g, String dep) {
		this.firstName = fn;
		this.lastName = ln;
		this.grade = g;
		this.department = dep;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getName() {
		return firstName + " " + lastName;
	}

	public String toString() {
		return String.format("%-10s %-10s %-10.2f %-10s", getFirstName(), getLastName(), getGrade(), getDepartment())
				.replace("[", "").replace("]", "");
	}
	//compare lastname then first name
	public int compareTo(Student n) {
		int lastCmp = lastName.compareTo(n.lastName); 
		int firstCmp = firstName.compareTo(n.firstName);
		if(lastCmp!=0)
			return lastCmp;
		else
			return firstCmp;
	}

}
