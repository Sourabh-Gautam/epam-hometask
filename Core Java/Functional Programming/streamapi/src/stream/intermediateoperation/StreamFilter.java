package stream.intermediateoperation;

import java.util.List;

public class StreamFilter {

	public static void main(String[] args) {

		List<Integer> list = List.of(5, 10, 15, 20, 25);
		
		// Imperative way
		
		System.out.println("Imperative way\n");
		
		for(Integer n : list) {
			if(n%2!=0)
				System.out.println(n);
		}
		
		// Declarative way
		
		System.out.println("\n\nDeclarative way\n");
		
		list.stream().filter(e -> e%2!=0).forEach(e -> System.out.println(e));
		
	}

}
