package stream.intermediateoperation;

import java.util.List;

public class StreamDistinct {

	public static void main(String[] args) {

		List<Integer> list = List.of(5, 10, 15, 20, 20, 5, 25);
		
		// Declarative way
		
		System.out.println("Declarative way\n");
		
		list.stream().distinct().forEach((e) -> System.out.println(e));
		
	}

}
