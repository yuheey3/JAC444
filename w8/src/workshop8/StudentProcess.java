/*
 * Name: Yuki Waka
 * Date: July 27,2020
 * 
 * */
package workshop8;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class StudentProcess extends Student {
	public StudentProcess(String fn, String ln, double g, String dep) {
		super(fn, ln, g, dep);

	}

	// get grade range 50.0-100.0
	public static List<Student> rangeGrade(List<Student> s) {
		return s.stream().filter(std -> std.getGrade() >= 50.0 && std.getGrade() <= 100.0).collect(Collectors.toList());
	}
 
	// compare grades
	public static Comparator<Student> Comparator = (student1,
			student2) -> (int) (student1.getGrade() - student2.getGrade());

	// compare last name then first
	public static Comparator<Student> NameComparator = (student1, student2) -> {

		return student1.compareTo(student2);
	};

	// mapping the unique last name
	public static List<String> uniqueLastName(List<Student> student) {
		return student.stream().map(s -> s.getLastName()).distinct().collect(Collectors.toList());
	}
	// mapping the first name and last name
	public static Stream<Object> fullName(List<Student> student) {
		return student.stream().map(s -> s.getFirstName() + " " + s.getLastName());
	}
	// grouping by department
	public static Map<String, List<Student>> department(List<Student> student) {
		return student.stream().collect(Collectors.groupingBy(Student::getDepartment));
	}
	// Counting by department
	public static Map<String, Long> count(List<Student> student) {
		return student.stream().collect(Collectors.groupingBy(Student::getDepartment, Collectors.counting()));
	}
	//map students' grade 
	public static DoubleStream grade(List<Student> student) {
		return student.stream().mapToDouble(Student::getGrade);
	}
  
}
