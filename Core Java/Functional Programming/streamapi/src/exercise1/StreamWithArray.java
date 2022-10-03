package exercise1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamWithArray {

	public static void main(String[] args) {
		int[] arr = {5, 10, 15, 20, 25, 30, 35, 40, 45, 50};
		IntStream stream = Arrays.stream(arr);
		stream.forEach(System.out::println);
 	}

}
