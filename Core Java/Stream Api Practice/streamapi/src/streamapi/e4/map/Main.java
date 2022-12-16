package streamapi.e4.map;

import java.util.List;

// Print the name of all person available in the list.

public class Main {
	public static void main(String[] args) {

		List<Person> list = List.of(
				new Person(1, "Sourabh", 22),
				new Person(1, "Simant", 17),
				new Person(1, "Monika", 25));
		list.stream().map(e -> e.getName()).forEach(System.out::println);
		
	}
}
