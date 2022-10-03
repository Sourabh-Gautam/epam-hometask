package com.collectors;

import java.util.List;
import java.util.stream.Collectors;

public class JavaCollectJoin {

	public static void main(String[] args) {
		var words = List.of("marble", "coin", "forest", "falcon", "sky", "cloud", "eagle", "lion");

		// can be replaced with String.join
		String joined = words.stream().collect(Collectors.joining(", "));

		System.out.printf(joined);
	}
}
