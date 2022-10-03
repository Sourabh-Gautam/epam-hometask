package stream.terminaloperation;

import java.util.List;

public class StreamForEach {

	public static void main(String[] args) {
		
		List<Integer> list = List.of(5, 10, 15, 20, 25);
		
		// Imperative way
		
		System.out.println("Imperative way\n");
		
		for(Integer n : list) {
			System.out.println(n);
		}
		
		// Declarative way
		
		System.out.println("\n\nDeclarative way\n");
		
		list.stream().forEach(e -> System.out.println(e));
		
	}

}
