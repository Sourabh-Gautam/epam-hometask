package stream.intermediateoperation;

import java.util.List;

public class StreamMap {

	public static void main(String[] args) {

		List<Integer> list = List.of(5, 10, 15, 20, 25);
		
		// Imperative way
		
		System.out.println("Imperative way\n");
		
		for(Integer n : list) {
				System.out.println((int)Math.pow(n, 2));
		}
		
		// Declarative way
		
		System.out.println("\n\nDeclarative way\n");
		
		list.stream().map(e -> (int)Math.pow(e, 2)).forEach((e) -> System.out.println(e));
		
	}

}
