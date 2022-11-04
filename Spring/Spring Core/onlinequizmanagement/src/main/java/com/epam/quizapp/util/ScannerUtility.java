package com.epam.quizapp.util;

import java.util.Scanner;

public class ScannerUtility {
	private static Scanner scanner;
	
	private ScannerUtility() {
	}
	
	public static Scanner openScanner() {
		if(scanner==null) {
			scanner = new Scanner(System.in);
		}
		return scanner;
	}
	
	public static void closeScanner() {
		scanner.close();
	}
}
