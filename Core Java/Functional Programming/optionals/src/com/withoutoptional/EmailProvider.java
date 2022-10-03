package com.withoutoptional;

import java.util.List;

public class EmailProvider {

	public static void main(String[] args) {
		String email = getEmail(2);
		if(email != null)
			System.out.println(email.toUpperCase());
		else
			System.out.println("Email Not Found!");
	}

	private static String getEmail(int id) {
		
		List<String> emailList = List.of("sourabh@gmail.com", "sumit@gmail.com","yogesh@gmail.com");
		if(id < emailList.size() && id > -1) {
			return emailList.get(id);
		}
		return null;
	}

}
