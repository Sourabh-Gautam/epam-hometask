package streamapi.e2.filter;

import java.util.List;

// Find the person object which name is Sourabh.

public class Main {
	public static void main(String[] args) {

		List<Person> list = List.of(
				new Person(1, "Sourabh", 22),
				new Person(1, "Simant", 22),
				new Person(1, "Monika", 22));
		Person person = list.stream().filter(e -> e.getName().equals("Sourabh")).findAny().orElse(null);
		System.out.println(person);
		
	}
}
