package com.epam.quizapp.util;

import java.util.Scanner;

public class ScannerUtility {
	private static Scanner scanner;
	
	private ScannerUtility() {
	}
	
	static {
		scanner = new Scanner(System.in);
	}
	
	public static Scanner openScanner() {
		return scanner;
	}
	
	public static void closeScanner() {
		scanner.close();
	}
}
