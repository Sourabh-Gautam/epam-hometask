package ConstructHomeTask;

import java.util.Scanner;

public class TrulyGreaterNumber {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter First Number : ");
		int fno = kb.nextInt();
		System.out.println("Enter Second Number : ");
		int sno = kb.nextInt();
		
		if(fno==6 || sno==6) {
			System.out.println(true);
		}
		
		else if((Math.abs(fno-sno))==6 || (fno+sno)==6) {
			System.out.println(true);
		}
		
		else {
			System.out.println(false);
		}
		
		kb.close();
	}

}
