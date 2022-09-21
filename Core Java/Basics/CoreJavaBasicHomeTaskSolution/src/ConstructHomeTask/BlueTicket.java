package ConstructHomeTask;

import java.util.Scanner;

public class BlueTicket {
	
	public static int blueTicket(int a, int b, int c) {
		  int ab = a+b;
		  int bc = b+c;
		  int ac = a+c;
		  
		  if(ab == 10 || bc == 10 || ac == 10) {
		    return 10;
		  }
		  else if(Math.abs(ab-bc)==10 || Math.abs(ab-ac)==10) {
		    return 5;
		  }
		  else {
		    return 0;
		  }
		  
		}

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		System.out.println("Enter value of a : ");
		int a = kb.nextInt();
		System.out.println("Enter value of b : ");
		int b = kb.nextInt();
		System.out.println("Enter value of c : ");
		int c = kb.nextInt();
		
		System.out.println(blueTicket(a, b, c));
		kb.close();

	}

}
