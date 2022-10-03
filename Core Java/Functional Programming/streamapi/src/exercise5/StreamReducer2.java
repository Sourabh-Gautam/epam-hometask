package exercise5;

// Print the sum of square of even integers present in the given list

import java.util.List;

public class StreamReducer2 {
	public static void main(String[] args) {
		List<Integer> li = List.of(5, 10, 15, 20, 25);
		int result = li.stream().filter(e -> e%2==0).map(e -> (int)Math.pow(e, 2)).reduce(0, (ans, e) -> ans+e);
		System.out.println(result);
	}
}
