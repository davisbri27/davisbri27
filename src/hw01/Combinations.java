package hw01;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * Recursive computation of all combinations of k characters from a string s.
 * 
 * @author Grant Braught
 * @author Dickinson College
 * @version Jan 28, 2016
 */
public class Combinations {

	private static int recusiveCalls = 0;

	/**
	 * Generate all combinations of the characters in the string s with length
	 * k.
	 * 
	 * @param s
	 *            a string.
	 * @param k
	 *            the length of the combinations
	 * @return a list of all of the combinations of the strings in s.
	 */
	public static ArrayList<String> combinations(String s, int k) {
		return combinations("", s, k);
	}

	/**
	 * Recursive Problem Transformation:
	 * 
	 * Generate all combinations of length k of the characters in rest prefixed
	 * with the characters in prefix. This is very similar to the subset method!
	 * 
	 * <code> 
	 * For example: 
	 *   combinations("", "ABC") -> "" before {AB, AC, BC}
	 *                           -> {AB, AC, BC}
	 *                      
	 *   combinations("A", "BC") -> A before {BC, B, C, ""} 
	 *                           -> {AB, AC} 
	 *                           
	 *   combinations("", "BC")  -> "" before {BC, B, C, ""} 
	 *                           -> {BC}
	 * </code>
	 */
	private static ArrayList<String> combinations(String prefix, String rest,
			int k) {
		
		ArrayList<String>subs= new ArrayList<String>();
		
		if(rest.length()==0){
			
			return subs;
			
		}else if(prefix.length()==k){
			subs.add(prefix);
			return subs; 
		}else if(prefix.length() + rest.length()< k){
			return subs;
			
		}else{
			
			ArrayList<String> incl= combinations(prefix+rest.charAt(0), rest.substring(1),k);
			subs.addAll(incl);
			
			ArrayList<String> excl= combinations(prefix, rest.substring(1), k);
			subs.addAll(excl);
			
			return subs;
		
		
	
	}
}
		


	public static void main(String[] args) {
		ArrayList<String> subs = combinations("ABCDE", 2);
		System.out.println("Calls: " + recusiveCalls);
		System.out.println("Size: " + subs.size());
		for (String s : subs) {
			System.out.println(s);
		}
	}

	@Test
	public void testOnlyOne() {
		ArrayList<String> comb = combinations("ABC",3);
		assertEquals("Incorrect number of combinations.", 1, comb.size());
		assertEquals("Incorrect combination generated.", "ABC", comb.get(0));
	}

	@Test
	public void testNoneEmptyInput() {
		ArrayList<String> comb = combinations("",2);
		assertEquals("Incorrect number of combinations.", 0, comb.size());
	}

	@Test
	public void testNoneKTooLarge() {
		ArrayList<String> comb = combinations("ABC",4);
		assertEquals("Incorrect number of combinations.", 0, comb.size());
	}

	@Test
	public void testABC1() {
		ArrayList<String> comb = combinations("ABC",1);
		assertEquals("Incorrect number of combinations.", 3, comb.size());
		assertTrue("Missing A.", comb.contains("A"));
		assertTrue("Missing B.", comb.contains("B"));
		assertTrue("Missing C.", comb.contains("C"));
	}

	@Test
	public void testABC2() {
		ArrayList<String> comb = combinations("ABC",2);
		assertEquals("Incorrect number of combinations.", 3, comb.size());
		assertTrue("Missing AB.", comb.contains("AB"));
		assertTrue("Missing AC.", comb.contains("AC"));
		assertTrue("Missing BC.", comb.contains("BC"));
	}

	@Test
	public void testABCD2() {
		ArrayList<String> comb = combinations("ABCD",2);
		assertEquals("Incorrect number of combinations.", 6, comb.size());
		assertTrue("Missing AB.", comb.contains("AB"));
		assertTrue("Missing AC.", comb.contains("AD"));
		assertTrue("Missing AD.", comb.contains("AD"));
		assertTrue("Missing BC.", comb.contains("BC"));
		assertTrue("Missing BD.", comb.contains("BD"));
		assertTrue("Missing CD.", comb.contains("CD"));
	}

	@Test
	public void testABCD3() {
		ArrayList<String> comb = combinations("ABCD",3);
		assertEquals("Incorrect number of combinations.", 4, comb.size());
		assertTrue("Missing ABC.", comb.contains("ABC"));
		assertTrue("Missing ABD.", comb.contains("ABD"));
		assertTrue("Missing ACD.", comb.contains("ACD"));
		assertTrue("Missing BCD.", comb.contains("BCD"));
	}

	@Test
	public void testABCDE2() {
		ArrayList<String> comb = combinations("ABCDE",2);
		assertEquals("Incorrect number of combinations.", 10, comb.size());
	}

	@Test
	public void testABCDE3() {
		ArrayList<String> comb = combinations("ABCDE",3);
		assertEquals("Incorrect number of combinations.", 10, comb.size());
	}

	@Test
	public void testABCDE4() {
		ArrayList<String> comb = combinations("ABCDE",4);
		assertEquals("Incorrect number of combinations.", 5, comb.size());
	}
}
