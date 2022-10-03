package stream.intermediateoperation;

import java.util.List;
import java.util.stream.Collectors;

public class StreamFlatMap {

	public static void main(String[] args) {

		List<List<Integer>> list = List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9));
		
		// Declarative way
		
		System.out.println("\n\nDeclarative way\n");
		
		System.out.println("Before flattening");
		
		System.out.println(list.stream().collect(Collectors.toList()));
		
		System.out.println("\n\nAfter flattening");
		
		System.out.println(list.stream().flatMap(e -> e.stream()).collect(Collectors.toList()));
		
	}

}
