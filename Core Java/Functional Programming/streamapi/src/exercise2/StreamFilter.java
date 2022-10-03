package exercise2;

import java.util.List;
import java.util.function.Predicate;

// Print only odd numbers from the list

public class StreamFilter {

	public static void main(String[] args) {
		List<Integer> li = List.of(5, 10, 15, 20, 25, 30, 35, 40, 45, 50);
		Predicate<Integer> predicate = e -> e%2!=0;
		li.stream().filter(predicate).forEach(System.out::println);
	}

}
