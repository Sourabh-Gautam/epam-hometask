package stream.intermediateoperation;

import java.util.List;

public class StreamLimit {

	public static void main(String[] args) {

		List<Integer> list = List.of(5, 10, 15, 20, 25);
		
		// Declarative way
		
		System.out.println("Declarative way\n");
		
		list.stream().limit(3).forEach((e) -> System.out.println(e));
		
	}

}
