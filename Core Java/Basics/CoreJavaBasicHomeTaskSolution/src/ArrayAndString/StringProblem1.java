package ArrayAndString;

import java.util.Arrays;
import java.util.Scanner;

//write a program to Print duplicate characters from String 

public class StringProblem1 {

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter a string : ");
		char[] arr = kb.next().toCharArray();
		Arrays.sort(arr);
		
		int j=0;
		boolean flag = false;
		
		for(int i=1; i<arr.length; i++) {
			
			if(flag) {
				if(arr[i]!=arr[j]) {
					j = i;
					flag = false;
				}
				continue;
			}
			
			if(arr[j]==arr[i]) {
				System.out.println(arr[j]);
				flag = true;
			}
			j++;
		}
		kb.close();

	}

}
