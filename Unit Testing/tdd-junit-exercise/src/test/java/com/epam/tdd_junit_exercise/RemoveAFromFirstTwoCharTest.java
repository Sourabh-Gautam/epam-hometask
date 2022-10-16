package com.epam.tdd_junit_exercise;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RemoveAFromFirstTwoCharTest {
	
//	 "ABCD" => "BCD"
//    "AACD" => "CD" 
//    "BACD" => "BCD"
//    "BBAA" => "BBAA"       
//    "AABAA" => "BAA"
//		"A" => ""
//		"" => ""
	
	RemoveAFromFirstTwoChar removeAFromFirstTwoChar;
	
	@BeforeEach
	public void setup() {
		removeAFromFirstTwoChar = new RemoveAFromFirstTwoChar();
	}
	
	@Test
	void moreThanTwoCharater() {
		assertEquals("BCD", removeAFromFirstTwoChar.remove("ABCD"));
		assertEquals("CD", removeAFromFirstTwoChar.remove("AACD"));
		assertEquals("BCD", removeAFromFirstTwoChar.remove("BACD"));
		assertEquals("BBAA", removeAFromFirstTwoChar.remove("BBAA"));
		assertEquals("BAA", removeAFromFirstTwoChar.remove("AABAA"));
	}
	
	@Test
	void singleCharater() {
		assertEquals("", removeAFromFirstTwoChar.remove("A"));
		assertEquals("B", removeAFromFirstTwoChar.remove("B"));
	}
	
	@Test
	void emptyString() {
		assertEquals("", removeAFromFirstTwoChar.remove(""));
	}
	
}
