package ConstructHomeTask;

import java.util.Scanner;

public class BadOrGoodParty {

	public static int teaParty(int tea, int candy) {
		if (tea < 5 || candy < 5) {
			return 0;
		} else if (Math.abs(tea - candy) >= tea || Math.abs(tea - candy) >= candy) {
			return 2;
		} else {
			return 1;
		}

	}

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		System.out.println("Enter Tea Value : ");
		int tea = kb.nextInt();
		System.out.println("Enter Candy Value : ");
		int candy = kb.nextInt();
		
		System.out.println(teaParty(tea, candy));
		kb.close();
	}

}
