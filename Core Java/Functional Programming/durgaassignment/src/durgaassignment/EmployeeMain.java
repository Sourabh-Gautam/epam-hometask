package durgaassignment;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeMain {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		EmployeeService employeeService = new EmployeeService();
		List<Employee> employeeList = employeeService.getEmoloyeeData();
		
//		1. How many male and female employees are there in the organization?
		
		Map<String, Long> map1 = employeeList.stream()
			.collect(Collectors.groupingBy(item -> item.getGender(), Collectors.counting()));
		
//		2. Print the name of all departments in the organization?
		
		Set<String> set1 = employeeList.stream()
			.collect(Collectors.mapping(e -> e.getDepartment(), Collectors.toSet()));
		
//		3. What is the average age of male and female employees?
		
		Map<String, List<Employee>> map2 = employeeList.stream()
			.collect(Collectors.groupingBy(item -> item.getGender()));
		
		Double femaleAvg = map2.get("Female").stream()
				.collect(Collectors.mapping(item -> item.getAge(), Collectors.averagingInt(e -> e)));
		Double maleAvg = map2.get("Male").stream()
				.collect(Collectors.mapping(item -> item.getAge(), Collectors.averagingInt(e -> e)));
		
//		4. Get the details of highest paid employee in the organization?
		
		Optional<Double> maxSal = employeeList.stream().map(e -> e.getSalary()).max((a, b) -> a.compareTo(b));
		
//		5. Get the names of all employees who have joined after 2015?
		
		List<String> empAfter2015 = employeeList.stream()
				.filter(e -> e.getYearOfJoining() > 2015)
				.collect(Collectors.mapping(e -> e.getName() + " - " + e.getYearOfJoining(), Collectors.toList()));
		
//		6. Count the number of employees in each department?
		
		Map<String, Long> departmentMap = employeeList.stream()
				.collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.counting()));
		
//		7. What is the average salary of each department?
		
		Map<String, Double> avgSalDept = employeeList.stream()
				.collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.averagingDouble(e -> e.getSalary())));
		
//		8. Get the details of youngest male employee in the product development
		
		Optional<Employee> youngestMaleOfPd = employeeList.stream()
			.filter(e -> e.getDepartment().equals("Product Development"))
			.min((a, b) -> ((Integer)a.getAge()).compareTo(b.getAge()));
		
//		9. Who has the most working experience in the organization?
		
		Optional<Employee> mostExpEmp = employeeList.stream()
				.min((a, b) -> ((Integer)a.getYearOfJoining()).compareTo(b.getYearOfJoining()));

//		10.How many male and female employees are there in the sales and marketing team?
		
		Map<String, Long> marketingTeam = employeeList.stream().filter(e -> e.getDepartment().equals("Sales And Marketing"))
			.collect(Collectors.groupingBy(e -> e.getGender(), Collectors.counting()));

//		11.What is the average salary of male and female employees?
		
		Map<String, Double> averageSalOfMaleFemale = employeeList.stream()
				.collect(Collectors.groupingBy(item -> item.getGender(), Collectors.averagingDouble(e -> e.getSalary())));
		
//		12. List down the names of all employees in each department?
		
		Map<String, List<Employee>> listEmpFromEachDept = employeeList.stream()
				.collect(Collectors.groupingBy(item -> item.getDepartment()));
		
//		listEmpFromEachDept.forEach((k, v) -> {
//			System.out.println(k+"\n");
//			v.forEach(e -> {
//				System.out.println(e.getName());
//			});
//			System.out.println("\n");
//		});
		
//		13.What is the average salary and total salary of the whole organization?
		
		double totalSal = employeeList.stream().collect(Collectors.summingDouble(e -> e.getSalary()));
		double avgSal = employeeList.stream().collect(Collectors.averagingDouble(e -> e.getSalary()));
		
		DoubleSummaryStatistics doubleSummaryStatistics = employeeList.stream().collect(Collectors.summarizingDouble(e -> e.getSalary()));

		//		System.out.println(doubleSummaryStatistics);
		
		
//		14.Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
		
		Map<Boolean, List<Employee>> distributeEmp = employeeList.stream()
				.collect(Collectors.partitioningBy(e -> e.getAge() <= 25));
		
		List<Employee> emp1 = distributeEmp.get(true);
		List<Employee> emp2 = distributeEmp.get(false);
		System.out.println(emp1);
		System.out.println(emp2);
		
//		distributeEmp.forEach((k, v) -> {
//			if(k) {
//				System.out.println("Employees who are younger or equal to 25 years\n");
//				v.forEach(e -> {
//					System.out.println(e.getName());
//				});
//				System.out.println();
//			}
//			else {
//				System.out.println("Employees who are elder than 25 years\n");
//				v.forEach(e -> {
//					System.out.println(e.getName());
//				});
//				System.out.println();
//			}
//		});
		
//		15.Who is the oldest employee in the organization? What is his age and which department he belongs to?
		
		Optional<Employee> oldestEmployee = employeeList.stream()
				.max((a, b) -> ((Integer)a.getAge()).compareTo(b.getAge()));
		
//		System.out.println("Name - "+oldestEmployee.get().getName());
//		System.out.println("Age - "+oldestEmployee.get().getAge());
//		System.out.println("Department - "+oldestEmployee.get().getDepartment());
		
	}
}