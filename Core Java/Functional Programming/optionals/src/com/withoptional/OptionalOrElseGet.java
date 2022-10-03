package com.withoptional;

import java.util.List;
import java.util.Optional;

public class OptionalOrElseGet {

	public static void main(String[] args) {
		Optional<String> optionalEmail = getEmail(2);
		System.out.println(optionalEmail.orElseGet(()-> "Match Not Found!"));
	}

	private static Optional<String> getEmail(int id) {

		List<String> emailList = List.of("sourabh@gmail.com", "sumit@gmail.com", "yogesh@gmail.com");
		if (id < emailList.size() && id > -1) {
			return Optional.ofNullable(emailList.get(id));
		}
		return Optional.ofNullable(null);
	}

}
