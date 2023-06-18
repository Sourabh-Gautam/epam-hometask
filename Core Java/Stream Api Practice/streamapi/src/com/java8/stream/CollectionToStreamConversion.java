package com.java8.stream;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Stream;

public class CollectionToStreamConversion {

	public static void main(String[] args) {
		
		// Convert a list to stream using Collection stream() method
		System.out.println("Convert a list to stream using Collection stream() method");
		List<Integer> list = List.of(1, 2, 3);
		Stream<Integer> stream = list.stream();
		stream.forEach(e -> System.out.println(e));
		
		// Convert a set to stream using Collection stream() method
		System.out.println("Convert a set to stream using Collection stream() method");
		Set<Integer> set = Set.of(1, 2, 3);
		Stream<Integer> stream2 = set.stream();
		stream2.forEach(e -> System.out.println(e));
		
		// Convert a map to stream using Collection stream() method
		System.out.println("Convert a map to stream using Collection stream() method");
		Map<Integer, String> map = Map.of(1, "Sourabh", 2, "Rohit", 3, "Sumit");
		Stream<Entry<Integer, String>> stream3 = map.entrySet().stream();
		stream3.forEach(e -> System.out.println(e.getKey()+" : "+e.getValue()));
		
	}
	
}
