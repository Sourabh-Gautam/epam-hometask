package com.epam;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SwapLastTwoCharTest {

	// To do list
	// 1. AB => BA
	// 2. ABCD => ABDC
	// 3. ABCDEFHIJ => ABCDEFHJI
	// 4. A => A
	// 5. "" => ""
	// 6. AAAA => AAAA
	// 7. A" " => " "A

	SwapLastTwoChar swapLastTwoChar;

	@BeforeEach
	public void setup() {
		swapLastTwoChar = new SwapLastTwoChar();
	}

	@Test
	void testNChars() {
		assertEquals("BA", swapLastTwoChar.swap("AB"));
		assertEquals("ABDC", swapLastTwoChar.swap("ABCD"));
		assertEquals("ABCDEFHJI", swapLastTwoChar.swap("ABCDEFHIJ"));
		assertEquals("AAAA", swapLastTwoChar.swap("AAAA"));
	}

	@Test
	void testSingleChar() {
		assertEquals("A", swapLastTwoChar.swap("A"));
	}

	@Test
	void testEmptyString() {
		assertEquals("", swapLastTwoChar.swap(""));
	}

	@Test
	void testCharWithSpace() {
		assertEquals(" A", swapLastTwoChar.swap("A "));
	}

}
