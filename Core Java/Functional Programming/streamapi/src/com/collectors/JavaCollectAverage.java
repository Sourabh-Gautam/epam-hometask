package com.collectors;

import java.util.List;
import java.util.stream.Collectors;

public class JavaCollectAverage {

	public static void main(String[] args) {
        var vals = List.of(1, 2, 3, 4, 5);

        // can be replaced with count
        Double n = vals.stream().collect(Collectors.averagingInt(e -> e));

        System.out.println(n);
	}
}
