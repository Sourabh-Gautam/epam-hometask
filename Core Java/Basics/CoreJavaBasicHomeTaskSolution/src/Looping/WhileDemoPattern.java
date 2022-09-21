package Looping;

import java.util.Scanner;

public class WhileDemoPattern {
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter number of rows :");
		int rows = kb.nextInt();
		System.out.println("Enter step value :");
		int step = kb.nextInt();
		
		// Main logic using while
		
		int i=0;
		int n = 0;
		
		while(i<rows) {
			int j=0;
			while(j<=i) {
				
				System.out.print(n+" ");
				n = n + step;
				j++;
				
			}
			
			i++;
			System.out.println();
			
		}
		
		kb.close();
		
	}

}
