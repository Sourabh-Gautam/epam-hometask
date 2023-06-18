package com.java8.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamToArrayConversion {
	public static void main(String[] args) {
		
		// Converting stream into array of objects
		Stream<Integer> stream = Stream.of(4, 1, 2, 3);
		Object[] array = stream.toArray();
		System.out.println(Arrays.toString(array));
		
		// Way 1 - Converting stream into array of integer
		Stream<Integer> stream2 = Stream.of(4, 1, 2, 3);
		Integer[] array2 = stream2.toArray(size -> {
			return new Integer[size];
		});
		System.out.println(Arrays.toString(array2));
		
		// Way 2 - Converting stream into array of integer
		Stream<Integer> stream3 = Stream.of(4, 1, 2, 3);
		Integer[] array3 = stream3.toArray(Integer[]::new);
		System.out.println(Arrays.toString(array3));
		
		// Converting stream into array of int
		Stream<Integer> stream4 = Stream.of(4, 1, 2, 3);
		int[] array4 = stream4.mapToInt(e -> e).toArray();
		System.out.println(Arrays.toString(array4));
		
		// Converting stream into array of double
		Stream<Integer> stream5 = Stream.of(4, 1, 2, 3);
		double[] array5 = stream5.mapToDouble(e -> e).toArray();
		System.out.println(Arrays.toString(array5));
		
	}
}
