package hw01;

import static org.junit.Assert.*;

import org.junit.Test;

public class CountXWithDubs {

	/**
	 * Count the number of 'x's in the string. Any 'x' that is followed by
	 * another 'x' should count double (e.g. "axxbxc" -> 4)
	 * 
	 * @param x a string.
	 * @return the count of x's.
	 */
	public static int countXWithDubs(String s) {
		return 0;
	}

	@Test
	public void testEmptyString() {
		assertEquals("Incorrect result with empty string", 0,
				countXWithDubs(""));
	}

	@Test
	public void testNoX() {
		assertEquals("Incorrect result with no x's", 0,
				countXWithDubs("abcdef"));
	}

	@Test
	public void testSingleX() {
		assertEquals("Incorrect result with one x", 1, countXWithDubs("abxcd"));
	}

	@Test
	public void testDoubleX() {
		assertEquals("Incorrect result with a double x", 3,
				countXWithDubs("abxxcd"));
	}

	@Test
	public void testThreeX() {
		assertEquals("Incorrect result with a tripple x", 5,
				countXWithDubs("abxxxcd"));
	}

	@Test
	public void testXStart() {
		assertEquals("Incorrect result with x at start", 2,
				countXWithDubs("xabxcd"));
	}

	@Test
	public void testXSEnd() {
		assertEquals("Incorrect result with x at end", 2,
				countXWithDubs("abxcdx"));
	}

	@Test
	public void testDoubleXStart() {
		assertEquals("Incorrect result with double x at start", 4,
				countXWithDubs("xxabxcd"));
	}
	
	@Test
	public void testDoubleXEnd() {
		assertEquals("Incorrect result with double x at end", 4,
				countXWithDubs("abxcdxx"));
	}
	
	@Test
	public void testBunchOfXs() {
		assertEquals("Incorrect result with bunch of x's", 13,
				countXWithDubs("xxxaxbxxcxdxx"));
	}
}
