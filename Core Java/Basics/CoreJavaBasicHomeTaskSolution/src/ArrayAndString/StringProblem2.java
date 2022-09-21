package ArrayAndString;

import java.util.Scanner;

//write a program to check if two strings are rotations of each other

public class StringProblem2 {

	public static void main(String[] args) {
		
//		String 1: abcde  
//		String 2 : deabc  
		
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter first string : ");
		String str1 = kb.next();
		System.out.println("Enter second string : ");
		String str2 = kb.next();
		
		if(str1.length()!=str2.length()) {
			System.out.println("No");
		}
		
		int index = -1;
		
		for(int i=0; i<str2.length(); i++) {
			if(str1.charAt(0)==str2.charAt(i)) {
				index = i;
			}
		}
		
		String result = str2.substring(index)+str2.substring(0, index);
		if(result.equals(str1)) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
		
		kb.close();

	}

}
