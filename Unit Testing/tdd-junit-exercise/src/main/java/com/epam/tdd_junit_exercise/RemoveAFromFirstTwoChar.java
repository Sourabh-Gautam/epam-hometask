package com.epam.tdd_junit_exercise;

public class RemoveAFromFirstTwoChar {

	public String remove(String input) {
		if(input.isEmpty()) {
			return "";
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		char firstChar = input.charAt(0);
		
		if(firstChar!='A') {
			stringBuilder.append(firstChar);
		}
		
		char secondChar = '\0';
		if(input.length()>1) {
			secondChar = input.charAt(1);
		}
		
		if(secondChar!='A' && secondChar!='\0') {
			stringBuilder.append(secondChar);
		}
		
		if(input.length()>2) {
			stringBuilder.append(input.substring(2, input.length()));
		}
		
		return stringBuilder.toString();
	}

}
