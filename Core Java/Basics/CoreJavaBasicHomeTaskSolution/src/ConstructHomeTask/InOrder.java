package ConstructHomeTask;

import java.util.Scanner;

public class InOrder {
	
	public static boolean inOrder(int a, int b, int c, boolean bOk) {
		  if(c>b) {
		    if(bOk) {
		      return true;
		    }
		    else {
		      if(b>a) {
		        return true;
		      }
		    }
		  }
		  return false;
		}

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter value of a : ");
		int a = kb.nextInt();
		System.out.println("Enter value of b : ");
		int b = kb.nextInt();
		System.out.println("Enter value of c : ");
		int c = kb.nextInt();
		System.out.println("Enter value of bOk : ");
		boolean bOk = kb.nextBoolean();
		
		System.out.println(inOrder(a, b, c, bOk));
		kb.close();
		
	}

}
