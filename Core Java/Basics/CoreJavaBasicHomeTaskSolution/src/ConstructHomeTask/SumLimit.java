package ConstructHomeTask;

import java.util.Scanner;

public class SumLimit {

	public static int sumLimit(int a, int b) {
		if (numLength(a + b) == numLength(a)) {
			return a + b;
		} else {
			return a;
		}

	}

	public static int numLength(int n) {
		int len = 0;
		while (n > 0) {
			n = n / 10;
			len++;
		}
		return len;
	}

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		System.out.println("Enter value of a : ");
		int a = kb.nextInt();
		System.out.println("Enter value of b : ");
		int b = kb.nextInt();

		System.out.println(sumLimit(a, b));
		kb.close();

	}

}
