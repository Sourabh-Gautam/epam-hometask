package stream.intermediateoperation;

import java.util.List;
import java.util.stream.Collectors;

public class StreamSorted {

	public static void main(String[] args) {
		
		List<Integer> list = List.of(4, 3, 5, 0, 2, 1);
		
		// Declarative way
		
		System.out.println("Declarative way\n");
		
		System.out.println(list.stream().sorted().collect(Collectors.toList()));
		
	}

}
