package hw01;

import static org.junit.Assert.*;

import org.junit.Test;

public class NestedParentheses {

	/**
	 * Check if the parentheses in the string s are properly nested. For
	 * example:
	 * 
	 * (()) - proper 
	 * 
	 * (() - not proper
	 * 
	 * An empty string is also considered to be a valid nesting.
	 * 
	 * @param s a string containing only the characters ( or ).
	 * @return true if the nesting is valid and false if not.
	 */
	public static boolean validNesting(String s) {
		return validNesting( s, 0, s.length()-1);
	}

	public static boolean validNesting(String s, int start, int end) {
		if(s.length()==0){
			return true;
		}
		if(s.length()==1){
			return false;
		}

		if(start>end){
			return true;
		}
		if(end==2 && s.charAt(start)==s.charAt(end-1)){
			return false;
		}

		String left= "(";
		String right= ")";
		String theFirst= String.valueOf(s.charAt(start));
		String theLast= String.valueOf(s.charAt(end));
		
		if(theFirst.equals(left) && theLast.equals(right)){
			
			return validNesting(s, start+1, end-1);
		}else{
			
			return false;
		}
	}

	@Test
	public void testEmptyString() {
		assertTrue("Incorrect result on empty string.", validNesting(""));
	}

	@Test
	public void testOneSetValid() {
		assertTrue("Incorrect result on ().", validNesting("()"));
	}

	@Test
	public void testLeftParenInvalid() {
		assertFalse("Incorrect result on (.", validNesting("("));
	}

	@Test
	public void testRightParenInvalid() {
		assertFalse("Incorrect result on ).", validNesting(")"));
	}

	@Test
	public void testTwoLeftInvalid() {
		assertFalse("Incorrect result on ((.", validNesting("(("));
	}

	@Test
	public void testTwoRightnvalid() {
		assertFalse("Incorrect result on ((.", validNesting("))"));
	}

	@Test
	public void testRightLefttnvalid() {
		assertFalse("Incorrect result on )(.", validNesting(")("));
	}

	@Test
	public void testMultipleValid() {
		assertTrue("Incorrect result on ((())).", validNesting("((()))"));
	}

	@Test
	public void testMultipleInvalid() {
		assertFalse("Incorrect result on ((((())).", validNesting("((((()))"));
	}
}
