package com.withoptional;

import java.util.Optional;

public class OptionalMap {

	public static void main(String[] args) {

		Optional<String> optional = Optional.empty();
		optional.map(null); // Why
	
	}	
}
