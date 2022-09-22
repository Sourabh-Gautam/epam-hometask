package BasicsOfCollection;

import java.util.HashMap;

public class Driver {

	public static void main(String[] args) {
		
		HashMap<String, String> map = new HashMap<>();
		map.put("String1", "String1");
		map.put("String1", "String2");
		map.put("String2", "String3");
		
		System.out.println(map);
		
		Student s1 = new Student("Student 1");
		Student s2 = new Student("Student 1");
		Student s3 = new Student("Student 2");
		
		Employee e1 = new Employee("Employee 1");
		Employee e2 = new Employee("Employee 2");
		Employee e3 = new Employee("Employee 3");
		
		HashMap<Student, Employee> custommap = new HashMap<>();
		custommap.put(s1, e1);
		custommap.put(s2, e2);
		custommap.put(s3, e3);
		
		System.out.println(custommap);

	}

}
