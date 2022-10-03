package exercise4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamCollect {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Reflection","Collection","Stream");
		List<String> result = names.stream().collect(Collectors.toList());
		System.out.println(result);
	}

}	
