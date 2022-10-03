package exercise5;

import java.util.List;

// Square every number in a list and find the sum of squares

public class StreamReducer {

	public static void main(String[] args) {
		List<Integer> li = List.of(5, 10);
		double result = li.stream().map(e -> Math.pow(e, 2)).reduce(0.0, (ans, e) -> ans+e);
		System.out.println(result);
	}

}
