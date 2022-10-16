package com.epam;

public class SwapLastTwoChar {

	public String swap(String input) {

		int length = input.length();

		String result = input;

		StringBuffer buffer = new StringBuffer();
		
		if (length >= 2) {

			buffer.append(input.substring(0, length - 2)).append(input.charAt(length - 1))
					.append(input.charAt(length - 2));

			result = buffer.toString();
		}

		return result;
	}
}
