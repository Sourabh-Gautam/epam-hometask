package ConstructHomeTask;

import java.util.Scanner;

public class WithoutString {

	public static String withoutString(String base, String remove) {
		int step = remove.length();

		StringBuilder sb = new StringBuilder();
		int i = step;
		for (; i < base.length(); i = i + 1) {
			if (base.substring(i - step, i).equalsIgnoreCase(remove)) {
				i = i + step - 1;
				continue;
			}
			sb.append(base.charAt(i - step));
		}

		if (!base.substring(i - step).equalsIgnoreCase(remove)) {
			sb.append(base.substring(i - step));
		}

		return sb.toString();
	}

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		System.out.println("Enter first string : ");
		String a = kb.next();
		System.out.println("Enter second string : ");
		String b = kb.next();
		
		System.out.println(withoutString(a, b));
		kb.close();

	}

}
