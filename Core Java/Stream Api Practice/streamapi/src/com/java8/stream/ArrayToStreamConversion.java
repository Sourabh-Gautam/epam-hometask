package com.java8.stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayToStreamConversion {
	public static void main(String[] args) {
		
        // Creating stream from an array of non-primitives
        System.out.println("One way : Creating stream from an array of non-primitives");
        Integer[] integerArr = {1, 2, 3};
        Stream<Integer> streamOfInteger = Stream.of(integerArr);
        streamOfInteger.forEach(e -> System.out.println(e));
        
        System.out.println("Second way : Creating stream from an array of non-primitives");
        Integer[] integerArr2 = {1, 2, 3};
        Stream<Integer> streamOfInteger2 = Arrays.stream(integerArr2);
        streamOfInteger2.forEach(e -> System.out.println(e));
        
        // Creating stream from an array of primitive
        System.out.println("Wrong way : Creating stream from an array of primitive");
        int[] intArr = {1, 2, 3};
        Stream<int[]> streamOfInt = Stream.of(intArr);
        streamOfInt.forEach(e -> System.out.println(e));
        
        System.out.println("Correct way : Creating stream from an array of primitives");
        int[] intArr2 = {1, 2, 3};
        IntStream streamOfInt2 = Arrays.stream(intArr2);
        streamOfInt2.forEach(e -> System.out.println(e));
        
	}
}
