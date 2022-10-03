package com.withoptional;

import java.util.Optional;

public class OptionalFilter {

	public static void main(String[] args) {

		Optional<String> optional = Optional.empty();
		optional.filter(null); // Why
	
	}	
}
