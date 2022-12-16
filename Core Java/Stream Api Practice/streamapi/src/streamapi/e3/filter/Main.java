package streamapi.e3.filter;

import java.util.List;

// Find the person object which name is Sourabh and Age is greate than 18.

public class Main {
	public static void main(String[] args) {

		List<Person> list = List.of(
				new Person(1, "Sourabh", 22),
				new Person(1, "Simant", 17),
				new Person(1, "Monika", 25));
		Person person = list.stream().filter(e -> e.getName().equals("Sourabh") && e.getAge()>18).findAny().orElse(null);
		System.out.println(person);
		
	}
}
