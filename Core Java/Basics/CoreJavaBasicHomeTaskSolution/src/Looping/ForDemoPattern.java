package Looping;

import java.util.Scanner;

public class ForDemoPattern {
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter number of rows :");
		int rows = kb.nextInt();
		System.out.println("Enter step value :");
		int step = kb.nextInt();
		
		// Main logic using while
		
		int n = 0;
		
		for(int i=0; i<rows; i++) {
			
			for(int j=0; j<=i; j++) {
				
				System.out.print(n+" ");
				n = n + step;
				
			}
			
			System.out.println();
			
		}
		
		kb.close();
		
	}

}
