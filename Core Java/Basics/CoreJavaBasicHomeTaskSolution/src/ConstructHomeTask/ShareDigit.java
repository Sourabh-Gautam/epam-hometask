package ConstructHomeTask;

import java.util.Scanner;

public class ShareDigit {
	
	public static boolean shareDigit(int a, int b) {
		  int al = a/10;
		  int ar = a%10;
		  
		  int bl = b/10;
		  int br = b%10;
		  
		  if(al==bl || al==br || ar==bl || ar==br) {
		    return true;
		  }
		  return false;
		}

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		System.out.println("Enter value of a : ");
		int a = kb.nextInt();
		System.out.println("Enter value of b : ");
		int b = kb.nextInt();
		
		System.out.println(shareDigit(a, b));
		kb.close();

	}

}
