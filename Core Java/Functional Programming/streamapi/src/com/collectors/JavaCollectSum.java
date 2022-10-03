package com.collectors;

import java.util.List;
import java.util.stream.Collectors;

public class JavaCollectSum {

	public static void main(String[] args) {
        var vals = List.of(1, 2, 3, 4, 5);

        // can be replaced with count
        var n = vals.stream().collect(Collectors.summingInt(e -> e));

        System.out.println(n);
	}
}
