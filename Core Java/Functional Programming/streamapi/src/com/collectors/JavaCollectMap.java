package com.collectors;

import java.util.List;
import java.util.stream.Collectors;

public class JavaCollectMap {

	public static void main(String[] args) {
		List<Integer> vals = List.of(1, 2, 3, 4, 5);

		List<Integer> set = vals.stream().collect(Collectors.mapping(e -> (int)Math.pow(e, 2), Collectors.toList()));

		System.out.print(set);
	}
}
