package ConstructHomeTask;

import java.util.Scanner;

public class DriveFastFine {

	public static int caughtSpeeding(int speed, boolean isBirthday) {
		if (speed <= 60) {
			return 0;
		} else if (speed > 60 && speed <= 80) {
			if (isBirthday) {
				if (speed - 5 <= 60) {
					return 0;
				}
			}
			return 1;
		} else {
			if (isBirthday) {
				if (speed - 5 <= 80) {
					return 1;
				}
			}
			return 2;
		}
	}

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		System.out.println("Enter speed : ");
		int speed = kb.nextInt();
		System.out.println("Is it your birthday ( true / false ) ?");
		boolean isBirthday = kb.nextBoolean();
		System.out.println(caughtSpeeding(speed, isBirthday));
		kb.close();
		
	}

}
