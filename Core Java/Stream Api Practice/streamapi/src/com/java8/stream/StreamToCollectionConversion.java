package com.java8.stream;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamToCollectionConversion {
	public static void main(String[] args) {
		
		// Convert a stream to list
		System.out.println("Convert a stream to list");
		Stream<Integer> stream = Stream.of(1, 2, 3);
		List<Integer> list = stream.toList();
		System.out.println(list);
		
		// Convert a stream to list
		System.out.println("Second way : Convert a stream to list");
		Stream<Integer> stream2 = Stream.of(1, 2, 3);
		List<Integer> list2 = stream2.collect(Collectors.toList());
		System.out.println(list2);
		
		// Convert a stream to set
		System.out.println("Convert a stream to list");
		Stream<Integer> stream3 = Stream.of(1, 2, 3);
		Set<Integer> set = stream3.collect(Collectors.toSet());
		System.out.println(set);
		
		// Convert a stream to map
		System.out.println("Convert a stream to list");
		Stream<Integer> stream4 = Stream.of(1, 2, 3);
		Map<Integer, Integer> map = stream4.collect(Collectors.toMap(key -> key, value -> value+2));
		System.out.println(map);
		
	}
}
