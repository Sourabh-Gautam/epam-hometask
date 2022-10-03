package stream.intermediateoperation;

import java.util.List;

public class StreamSkip {

	public static void main(String[] args) {

		List<Integer> list = List.of(5, 10, 15, 20, 25);
		
		// Declarative way
		
		System.out.println("Declarative way\n");
		
		list.stream().skip(2).forEach((e) -> System.out.println(e));
		
	}

}
