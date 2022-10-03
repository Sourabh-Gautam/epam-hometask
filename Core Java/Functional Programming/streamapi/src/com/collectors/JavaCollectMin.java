package com.collectors;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class JavaCollectMin {

	public static void main(String[] args) {
        var vals = List.of(1, 2, 3, 4, 5);

        // can be replaced with count
        Optional<Integer> n = vals.stream().collect(Collectors.minBy(Integer::compareTo));

        System.out.println(n.orElse(0));
	}
}
