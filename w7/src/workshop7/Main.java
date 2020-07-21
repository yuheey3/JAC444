/*
 * Name: Yuki Waka
 * Date: July 20,2020
 * 
 * */
package workshop7;
import java.util.*;

public class Main {
	
	public static void main(String args[]) {
		
		Student[] s = { 
				new Student("Yuki", "Waka",100.0,"IT"),
				new Student("Gihoon", "Kim",76.0,"IT"),
				new Student("Jin", "Kim",35.8,"Business"), 
				new Student("Eri", "Hashimoto",47.0,"Media"),
				new Student("Eric", "Hashimoto",43.0,"IT"),
				new Student("Ian", "Kwon",87.0,"Accounting"),
				new Student("Jonwong", "Kim",53.87,"Business") };
			
		System.out.println("Task 1: \n\nComplete Student list:");
		List<Student> list = Arrays.asList(s);	
		list.stream().forEach(ele -> System.out.println(ele));
		
		System.out.println("\nTask 2: \n\nStudents who got 50.0-100.0 sorted by grade:");
		list.sort(StudentProcess.Comparator);
	    StudentProcess.rangeGrade(list).forEach(sEle -> System.out.println(sEle.toString()));

	    System.out.println("\nTask 3: \n\nFirst Student who got 50.0-100.0:");
	    list.sort(StudentProcess.Comparator);
	    System.out.println(StudentProcess.rangeGrade(list).get(0));
	    
	    System.out.println("\nTask 4: \n\nStudents in ascending order by last name then first:");
	    list.sort(StudentProcess.NameComparator);
	    list.forEach(sName -> System.out.println(sName.toString()));

        System.out.println("\nStudent in descending order by last name then first: ");
        list.sort((StudentProcess.NameComparator).reversed());
	    list.forEach(sName -> System.out.println(sName.toString()));
	
	    System.out.println("\nTask 5: \n\nUnique Student last names:");
	    list.sort(StudentProcess.NameComparator);
        StudentProcess.uniqueLastName(list).forEach(lName -> System.out.println(lName));
	}
}
