package exercise3;

import java.util.List;

// Square every number in a list

public class StreamMap {

	public static void main(String[] args) {
		List<Integer> li = List.of(5, 10, 15, 20, 25, 30, 35, 40, 45, 50);
		li.stream().map(e -> Math.pow(e, 2)).forEach(System.out::println);
	}

}
