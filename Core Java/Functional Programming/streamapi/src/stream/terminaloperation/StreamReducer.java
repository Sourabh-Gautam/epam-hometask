package stream.terminaloperation;

import java.util.List;

public class StreamReducer {

	public static void main(String[] args) {
		
		List<Integer> list = List.of(5, 10, 15, 20, 25);
		
		// Imperative way
		
		System.out.println("Imperative way\n");
		
		int sum=0;
		for(Integer n : list) {
			sum += n;
		}
		System.out.println(sum);
		
		// Declarative way
		
		System.out.println("\n\nDeclarative way\n");
		
		System.out.println(list.stream().reduce(0, (a, b) -> a+b));
		
	}

}
