package ConstructHomeTask;

import java.util.Scanner;

public class MaxBlock {

	public static int maxBlock(String str) {

		if (str.equals("")) {
			return 0;
		}

		int i = 0;
		int j = 1;
		int count = 1;
		int max = 1;
		boolean flag = false;

		while (j < str.length()) {
			if (str.charAt(i) == str.charAt(j)) {
				j++;
				count++;
				flag = true;
				continue;
			}

			if (flag) {
				if (count > max) {
					max = count;
				}
				i = j;
				j++;
				count = 1;
				flag = false;
				continue;
			}

			i++;
			j++;

		}

		if (count > max) {
			return count;
		}

		return max;
	}

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter a string : ");
		String str = kb.next();
		
		System.out.println(maxBlock(str));
		kb.close();

	}

}
