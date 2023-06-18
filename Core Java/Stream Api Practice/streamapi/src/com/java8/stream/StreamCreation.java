package com.java8.stream;

import java.util.Random;
import java.util.stream.Stream;

public class StreamCreation {

	public static void main(String[] args) {
		// Stream empty() method
		System.out.println("Stream empty() method");
		Stream<Integer> emptyStream = Stream.empty();
		emptyStream.forEach(e -> System.out.println(e));
		
		// Stream of() method
		System.out.println("Stream of() method");
		Stream<Integer> ofStream = Stream.of(1, 2, 3);
		ofStream.forEach(e -> System.out.println(e));
		
		// Stream ofNullable() method
		System.out.println("Stream ofNullable() method");
		Stream<Integer> ofNullableStream = Stream.ofNullable(null);
		ofNullableStream.forEach(e -> System.out.println(e));
		
		// Stream builder() method
		System.out.println("Stream builder() method");
		Stream<Object> builderStream = Stream.builder().add(1).add(2).add(3).build();
		builderStream.forEach(e -> System.out.println(e));
		
		// Stream concat() method
		System.out.println("Stream concat() method");
        Stream<Integer> stream1 = Stream.of(1);
        Stream<Integer> stream2 = Stream.of(2,3);
        Stream.concat(stream1, stream2)
            .forEach(element -> System.out.println(element));
        
        // Stream generate() method
        System.out.println("Stream generate() method");
        Stream.generate(() -> new Random().nextInt()).limit(3).forEach( e -> System.out.println(e));
        Stream.generate(() -> "Sourabh").limit(3).forEach( e -> System.out.println(e));
        
		
	}

}
