package streamapi.e1.filter;

import java.util.Arrays;

// Print the elements of array which start with S

public class Main {
	public static void main(String[] args) {

		String []arr = {"Sourabh", "Simant", "Monika"};
		Arrays.stream(arr).filter(e -> e.startsWith("S")).forEach(System.out::println);
		
	}
}
