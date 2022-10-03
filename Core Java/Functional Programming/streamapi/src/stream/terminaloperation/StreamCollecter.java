package stream.terminaloperation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamCollecter {

	public static void main(String[] args) {
		
		List<Integer> list = List.of(5, 10, 15, 20, 25);
		
		// Imperative way
		
		System.out.println("Imperative way\n");
		
		ArrayList<Integer> container = new ArrayList<>();
		for(Integer n : list) {
			container.add(n);
		}
		System.out.println(container);
		
		// Declarative way
		
		System.out.println("\n\nDeclarative way\n");
		
		System.out.println(list.stream().collect(Collectors.toList()));
		
	}

}
